package redbee.challenge.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ftesei on 19/07/17.
 */
@Entity
@Table(name = "WINDS")
public class Wind implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private String  chill,
            speed,
            direction;

    public Wind(String chill, String speed, String direction){
        setChill(chill);
        setSpeed(speed);
        setDirection(direction);
    }
    public Wind(){}

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
