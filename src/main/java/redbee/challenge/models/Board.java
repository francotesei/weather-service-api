package redbee.challenge.models;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
@Entity
@Table(name = "BOARDS")
//@Document(collection = "boards")
public class Board  implements Serializable {
    @Id
    @Column(name = "BOARD_ID", unique = true, nullable = false)
    private String id;
    private String name;
    private String  rising,
                    visibility,
                    humidity,
                    pressure,
                    date,
                    code,
                    status,
                    country,
                    city,
                    lat,
                    lng,
                    sunrise,
                    sunset;
    @OneToOne(cascade = CascadeType.ALL)
    private Wind    wind;
    private int     temp;
    //@JsonIgnore
    @OneToMany(fetch  = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "BOARD_FORECAST", joinColumns = { @JoinColumn(name = "BOARD_ID") }
            , inverseJoinColumns = { @JoinColumn(name = "FORECAST_ID") })
    private List<Forecast> forecasts = new ArrayList<>();

    public Board(){}
    public Board(String id){
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }


    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public List<Forecast> getForecasts() {

        return forecasts;
    }

    public void setForecasts(ArrayList<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
