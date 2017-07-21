package redbee.challenge.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ftesei on 19/07/17.
 */
@Entity
@Table(name = "FORECASTS")
public class Forecast implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private String  date,
            day,
            status,
            code;
    private int high,
            low;

    public Forecast(String date,String day,String status,String code,int high,int low){
        setDate(date);
        setDay(day);
        setStatus(status);
        setCode(code);
        setHigh(high);
        setLow(low);
    }
    public Forecast(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
