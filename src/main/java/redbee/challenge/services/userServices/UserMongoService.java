package redbee.challenge.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import redbee.challenge.db.MongoConnector;
import redbee.challenge.models.User;

import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */

public class UserMongoService extends UserBaseService {
    @Autowired
    private MongoConnector mongoService = new MongoConnector();


    public UserMongoService(){


    };
    @Override
    public User findById(String id){
        mongoService.connect();
        User user =  mongoService.getMongoOperation().findOne(new Query(Criteria.where("id").is(id)),User.class);
        mongoService.disconnect();
        return  user;
    }

    @Override
    public List<User> findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<User> findAll()  {
      mongoService.connect();
        List<User> list = mongoService.getMongoOperation().findAll(User.class);
        mongoService.disconnect();
        return  list;

    }

    @Override
    public User save(User obj) {
    mongoService.connect();
    mongoService.getMongoOperation().save(obj);
    mongoService.disconnect();
    return obj;
    }

    @Override
    public void save(List<User> list) {

    }

    @Override
    public User update(User obj) {
       return  save(obj); //si no existe lo crea.
    }

    @Override
    public void delete(String id) {
    User user  = new User();
    user.setId(id);
    mongoService.connect();
    mongoService.getMongoOperation().remove(new Query(Criteria.where("id").is(id)),User.class);
    mongoService.disconnect();
    }


}
