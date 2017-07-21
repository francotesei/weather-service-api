package redbee.challenge.models;


import org.springframework.data.mongodb.core.mapping.Document;
import redbee.challenge.services.userServices.UserService;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ftesei on 13/07/17.
 */
@Entity
@Table(name = "TOKENS")
@Document(collection = "tokens")
public class Token implements Serializable {
    @Id
    @Column(name = "token_id", unique = true, nullable = false)
    private String id = "";
    private String timeStamp = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss").format(Calendar.getInstance().getTime());
    @JoinTable(name = "USERS", joinColumns = { @JoinColumn(name = "USER_ID") })
    private String userid;
    public Token(String... params){
        for (String p:params)
            setId(id+=p);
    }
    public Token(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
