package redbee.challenge.services.userServices;

import redbee.challenge.db.PostgresConnector;
import redbee.challenge.models.User;

import java.util.List;

/**
 * Created by ftesei on 19/07/17.
 */
public class UserPostgresService  extends UserBaseService  {
    private PostgresConnector postgresConnector = new PostgresConnector();
    @Override
    public User findById(String id) throws Exception {
       postgresConnector.connect();
       postgresConnector.beginTransaction();
       User user = (User) postgresConnector.getOperations().get(User.class,id);
       postgresConnector.commit();
       postgresConnector.disconnect();
       if(user !=  null)
           user.deleteRepeatBoard();
        return user;
    }

    @Override
    public List<User> findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<User> findAll() {

        postgresConnector.connect();
        postgresConnector.beginTransaction();
        List<User> users = postgresConnector.getOperations().createCriteria(User.class).list();
        postgresConnector.disconnect();
        return users;
    }


    @Override
    public User save(User obj) {
        postgresConnector.connect();
        postgresConnector.beginTransaction();
        postgresConnector.getOperations().save(obj);
        postgresConnector.commit();
        postgresConnector.disconnect();
        return obj;
    }

    @Override
    public void save(List<User> list) {


    }

    @Override
    public User update(User obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
