package redbee.challenge;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redbee.challenge.YQL.WeatherApi;



@SpringBootApplication
public class App {

	public static void main(String[] args) throws Exception {

			boolean polling = Properties.getInstance()
				.getProperty("polling").equals("true");
			boolean isPosgres = Properties.getInstance().getProperty("UseConnection").equals("POSTGRESQL");


			SpringApplication.run(App.class, args);
		if(polling) WeatherApi.startPollingWeather();
		if(isPosgres)Postgres.getInstance();



	}
}
