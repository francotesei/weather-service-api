package redbee.challenge.services.loginServices;

import redbee.challenge.db.PostgresConnector;
import redbee.challenge.models.Token;
import redbee.challenge.models.User;
import redbee.challenge.services.Service;
import redbee.challenge.services.ServiceFactory;


/**
 * Created by ftesei on 19/07/17.
 */
public class LoginPostgresService extends LoginBaseService {

    private PostgresConnector postgresConnector = new PostgresConnector();
    @Override
    public Token singUp(String username, String pass) throws Exception {
        Service service = ServiceFactory.createServiceUser();
        if(service.findById(username) !=  null)
            return  null;
        postgresConnector.connect();
        User user = new User();
        Token token = new Token(username+pass);
        token.setUserid(username);
        user.setId(username);
        user.setPass(pass);
        user.setName(username);
        user.setToken(token);
        postgresConnector.beginTransaction();
        postgresConnector.getOperations().save(user);
        postgresConnector.commit();
        postgresConnector.disconnect();
        return user.getToken();
    }

    @Override
    public Token singIn(String username, String pass) throws Exception {
        Service service = ServiceFactory.createServiceUser();
        User user ;
        if((user = (User) service.findById(username)) == null || !user.getPass().equals(pass)){
            return null;
        }
        postgresConnector.connect();
        Token token = new Token(username+pass);
        token.setUserid(username);
        user.setToken(token);
        postgresConnector.beginTransaction();
        postgresConnector.getOperations().update(user);
        postgresConnector.commit();
        postgresConnector.disconnect();
        return user.getToken();
    }

    @Override
    public Token validateSession(String username, String tokenId) throws Exception {

        Service service = ServiceFactory.createServiceUser();
        User user ;
        if((user = (User) service.findById(username)) == null || !user.getToken().getId().equals(tokenId)){
            return null;
        }
        return user.getToken();
    }


    @Override
    public void logout(String username) throws Exception {
        Service service = ServiceFactory.createServiceUser();
        User user ;
        if((user = (User) service.findById(username)) == null)
            return;
        user.setToken(null);
        postgresConnector.connect();
        postgresConnector.beginTransaction();
        postgresConnector.getOperations().update(user);
        postgresConnector.commit();
        postgresConnector.disconnect();
        }

    }

