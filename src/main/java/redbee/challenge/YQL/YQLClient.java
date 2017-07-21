package redbee.challenge.YQL;





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ftesei on 12/07/17.
 */
public class YQLClient {
    private static final  String BASE_URL = "http://query.yahooapis.com/v1/public/yql?q=";
    private String query;
    private String lastResponse;
    private HashMap<String ,String> params =  new HashMap<>();

    public YQLClient(){}

    public YQLClient(String query,HashMap params){
        setQuery(query);
        setParams(params);
    }

    public String execute() throws Exception {
        setLastResponse(getResponse());
       return getLastResponse();
    }

    private  String getResponse() throws Exception {
        String urlToRead = BASE_URL + URLEncoder.encode(this.getQueryWithValues(query), "UTF-8") + "&format=json";
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    private String getQueryWithValues(String query) {
        if(getParams() == null || getParams().isEmpty())
            return query;

        Iterator it = getParams().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
          query = query.replaceAll((String)e.getKey(),(String)e.getValue());
        }
        return query;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void addParam(String key,String value){
        getParams().put(key,value);
    }

    public String getParam(String key) {
        return getParams().get(key);
    }


    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


    public String getLastResponse() {
        return lastResponse;
    }

    public void setLastResponse(String lastResponse) {
        this.lastResponse = lastResponse;
    }
}
