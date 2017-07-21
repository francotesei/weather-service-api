package redbee.challenge.YQL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import redbee.challenge.Properties;
import redbee.challenge.models.Board;
import redbee.challenge.models.Forecast;
import redbee.challenge.models.Wind;
import redbee.challenge.services.boardServices.BoardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;

/**
 * Created by ftesei on 17/07/17.
 */
public class WeatherApi {

    private static YQLClient yqlClient = new YQLClient();

    private static void poolData(JSONObject data, Board board) throws Exception {

        board.setRising(data.getJSONObject("atmosphere").getString("rising"));
        board.setVisibility(data.getJSONObject("atmosphere").getString("visibility"));
        board.setHumidity(data.getJSONObject("atmosphere").getString("humidity"));
        board.setPressure(data.getJSONObject("atmosphere").getString("pressure"));
        board.setDate(data.getJSONObject("item").getJSONObject("condition").getString("date"));
        board.setTemp(convertFahToCent(new BigDecimal(data.getJSONObject("item").getJSONObject("condition")
                .getString("temp"))));
        board.setCode(data.getJSONObject("item").getJSONObject("condition").getString("code"));
        board.setStatus(data.getJSONObject("item").getJSONObject("condition").getString("text"));
        board.setCountry(data.getJSONObject("location").getString("country"));
        board.setCity(data.getJSONObject("location").getString("city"));
        board.setLat(data.getJSONObject("item").getString("lat"));
        board.setLng(data.getJSONObject("item").getString("long"));
        board.setWind(new Wind(
                data.getJSONObject("wind").getString("chill"),
                data.getJSONObject("wind").getString("speed"),
                data.getJSONObject("wind").getString("direction")));
        JSONArray JsonForecast = data.getJSONObject("item").getJSONArray("forecast");
        board.getForecasts().clear();
        for (int i = 0; i < JsonForecast.length(); i++) {
            board.getForecasts().add(new Forecast(
                    JsonForecast.getJSONObject(i).getString("date"),
                    JsonForecast.getJSONObject(i).getString("day"),
                    JsonForecast.getJSONObject(i).getString("text"),
                    JsonForecast.getJSONObject(i).getString("code"),
                    convertFahToCent(new BigDecimal(JsonForecast.getJSONObject(i).getString("high"))),
                    convertFahToCent(new BigDecimal(JsonForecast.getJSONObject(i).getString("low")))
            ));
        }
    }

    private static int convertFahToCent(BigDecimal fah) {
      fah =  fah.add(new BigDecimal(-32)).multiply(new BigDecimal(0.5));
        return fah.intValue();

    }

    private static JSONObject resolveHeaderData(String jsonString) throws Exception {
        JSONObject query;
        try {
            query = new JSONObject(jsonString).getJSONObject("query");
        } catch (JSONException e) {
            throw new Exception(e.toString());
        }
        if (query.isNull("results")) {
            return null;
        }
        return query.getJSONObject("results");
    }

    public static boolean getBoardsByName(String name, List<Board> boards) throws Exception {
        yqlClient.setQuery("select woeid,name,country.content from geo.places where text = '@name'");
        yqlClient.addParam("@name", name);
        if (loadBoardsData(yqlClient.execute(), boards))
            return loadBoardDataExtended(boards);
        return false;
    }

    private static boolean loadBoardDataExtended(List<Board> boards) throws Exception {
        yqlClient = new YQLClient();
        String condition = "";
        for (Board board : boards)
            condition += "'" + board.getId() + "',";

        if(!StringUtils.isEmpty(condition)) {
            condition = condition.substring(0, condition.length() - 1);
            yqlClient.setQuery("select * from weather.forecast where woeid in(" + condition + ")");
            JSONObject result = resolveHeaderData(yqlClient.execute());
            if (result == null)
                return false;

            Object json = result.get("channel");
            if (json instanceof JSONObject) {
                JSONObject r = (JSONObject) json;
                poolData(r, boards.get(0));
            } else if (json instanceof JSONArray) {
                JSONArray results = (JSONArray) json;
                for (int i = 0; i < results.length(); i++) {
                    poolData(results.getJSONObject(i), boards.get(i));
                }
            }
        }
        return true;

    }

    private static boolean loadBoardsData(String jsonString, List<Board> boards) throws Exception {
        JSONObject result = resolveHeaderData(jsonString);

        if (result == null)
            return false;
        Object json = result.get("place");

        if(json instanceof JSONObject){
            JSONObject place = (JSONObject) json;
            Board board = new Board();
            board.setId(place.getString("woeid"));
            board.setName(place.getString("name").toLowerCase());
            board.setCountry(place.getString("country"));
            boards.add(board);

        }else if(json instanceof JSONArray){
            JSONArray places = (JSONArray) json;
            for (int i = 0; i < places.length(); i++) {
                Board board = new Board();
                board.setId(places.getJSONObject(i).getString("woeid"));
                board.setName(places.getJSONObject(i).getString("name").toLowerCase());
                board.setCountry(places.getJSONObject(i).getString("country"));
                boards.add(board);
            }
        }
        return true;
    }

    public static void startPollingWeather() throws InterruptedException {
        Timer timer = new Timer();
        int pollingInterval = parseInt(Properties.getInstance().getProperty("pollingInterval"));
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Update Weather Boards -- > Run");
                try {
                    updateBoards();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.toString());
                    this.cancel();
                }
                System.out.println("Update Weather Boards -- > End");
            }}, 0, (pollingInterval*1000));
    }

    private static void updateBoards() throws Exception {
        BoardService boardService = new BoardService();
       List<Board> boards =  boardService.findAll();
     if(loadBoardDataExtended(boards));
        boardService.save(boards);

    }
}