package redbee.challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ftesei on 10/07/17.
 */
@Entity
@Table(name = "USERS")
//@Document(collection = "users")
public class User implements Serializable   {
    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    private String id;
    @Column(name = "name", unique = false, nullable = false, length = 100)
    private String name;
    @Column(name = "pass", unique = false, nullable = false, length = 100)
    private String pass;

   // @Column(name = "token", unique = false, nullable = true)
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="token_id")
    private Token token;
    //@Column(name = "board", unique = false, nullable = true)
    //@JsonIgnore
    @OneToMany(fetch  = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_BOARD", joinColumns = { @JoinColumn(name = "USER_ID") }
    , inverseJoinColumns = { @JoinColumn(name = "BOARD_ID") })
    private List<Board> boards = new ArrayList();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Board> getBoards() {

        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }


    public void addNewBoard(boolean validate, Board board) {
        if(validate){
            for (Board b:getBoards()){
                if(b.getId().equals(board.getId()))
                    return;
            }
        }
        getBoards().add(board);
    }

    public void deleteBoard(Board board) {
        List<Board>  boards = new ArrayList<>();
        boards.addAll(getBoards());
    for (Board b:boards)
        if(b.getId().equals(board.getId()))
            getBoards().remove(b);
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public void deleteRepeatBoard() {

        Set<Board> hs = new HashSet<>();
        hs.addAll(getBoards());
        getBoards().clear();
        getBoards().addAll(hs);
    }
}
