package redbee.challenge.services.loginServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import redbee.challenge.db.MongoConfiguration;
import redbee.challenge.db.MongoConnector;
import redbee.challenge.models.Token;
import redbee.challenge.models.User;

/**
 * Created by ftesei on 13/07/17.
 */
public class LoginMongoService extends LoginBaseService {
    @Autowired
    private MongoConnector mongoService = new MongoConnector();

    public Token singUp(String username, String pass) {
        User user = new User();
        user.setId(username);
        user.setName(username);
        user.setPass(pass);
        mongoService.connect();
        if(!mongoService.getMongoOperation()
                .exists(new Query(Criteria.where("id")
                        .is(user.getId())),User.class)){

            user.setToken(new Token(username,pass));
            mongoService.getMongoOperation().save(user);
        }
        mongoService.disconnect();
        return user.getToken();

    }

    public Token singIn(String username, String pass)  {
        mongoService.connect();
        User user = mongoService.getMongoOperation()
                    .findOne(new Query(Criteria
                        .where("id").is(username)
                        .and("pass").is(pass)),User.class);

        if(user != null){
            user.setToken(new Token(username,pass));
            mongoService.getMongoOperation().save(user);
        }else {
            user = new User();
        }
         mongoService.disconnect();
        return user.getToken();

    }

    public Token validateSession(String username, String tokenId){
        mongoService.connect();
        User user = mongoService.getMongoOperation().findOne(new Query(Criteria
                .where("id").is(username)),User.class);
        mongoService.disconnect();

        if(user != null && user.getToken().getId().equals(tokenId)){
            return user.getToken();
        }
        return null;
    }

    public void logout(String username) {

        mongoService.connect();
        User user = mongoService.getMongoOperation().findOne(new Query(Criteria
                .where("id").is(username)),User.class);
        if(user != null){
            user.setToken(new Token());
            mongoService.getMongoOperation().save(user);
        }
        mongoService.disconnect();
    }
}
