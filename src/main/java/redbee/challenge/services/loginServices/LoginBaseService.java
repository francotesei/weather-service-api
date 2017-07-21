package redbee.challenge.services.loginServices;


import redbee.challenge.models.Token;

/**
 * Created by ftesei on 19/07/17.
 */
public abstract class LoginBaseService {
    public abstract Token singUp(String username, String pass) throws Exception;
    public abstract Token singIn(String username, String pass) throws Exception;
    public abstract Token validateSession(String username, String tokenId) throws Exception;
    public abstract void logout(String username) throws Exception;
}
