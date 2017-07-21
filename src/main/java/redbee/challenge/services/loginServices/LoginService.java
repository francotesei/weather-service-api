package redbee.challenge.services.loginServices;

import org.springframework.beans.factory.annotation.Autowired;
import redbee.challenge.Properties;
import redbee.challenge.services.ServiceFactory;
import redbee.challenge.models.Token;

/**
 * Created by ftesei on 13/07/17.
 */
public class LoginService extends LoginBaseService {
    @Autowired
    private LoginBaseService service = ServiceFactory.createServiceLogin();

    public Token singUp(String username, String pass) throws Exception {
       return service.singUp(username,pass);

    }

    public Token singIn(String username, String pass) throws Exception {
     return service.singIn(username,pass);

    }

    public Token validateSession(String username, String tokenId) throws Exception {
       return service.validateSession(username,tokenId);
    }

    public void logout(String username) throws Exception {
        service.logout(username);

    }
}
