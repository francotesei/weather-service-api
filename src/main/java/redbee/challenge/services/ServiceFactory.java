package redbee.challenge.services;

import redbee.challenge.Properties;
import redbee.challenge.models.Board;
import redbee.challenge.models.User;
import redbee.challenge.services.boardServices.BoardBaseService;
import redbee.challenge.services.loginServices.LoginBaseService;
import redbee.challenge.services.loginServices.LoginMongoService;
import redbee.challenge.services.boardServices.BoardMongoService;
import redbee.challenge.services.boardServices.BoardPostgresService;
import redbee.challenge.services.Service;
import redbee.challenge.services.loginServices.LoginPostgresService;
import redbee.challenge.services.userServices.UserBaseService;
import redbee.challenge.services.userServices.UserMongoService;
import redbee.challenge.services.userServices.UserPostgresService;

/**
 * Created by ftesei on 11/07/17.
 */
public   class ServiceFactory {
    public static UserBaseService createServiceUser(ServiceType s) {
    return (UserBaseService) createService(s,User.class);
    }

    public static UserBaseService createServiceUser() {
        return createServiceUser(getServiceTypeProp());
    }

    public static LoginBaseService createServiceLogin() {
        return createServiceLogin(getServiceTypeProp());
    }

    public static BoardBaseService createServiceBoard() {
        return createServiceBoard(getServiceTypeProp());
    }

    public enum ServiceType{
        MONGO,POSTGRESQL
    }

    public static BoardBaseService createServiceBoard(ServiceType serviceType) {
        return (BoardBaseService) createService(serviceType,Board.class);

    }

    public static LoginBaseService createServiceLogin(ServiceType s) {
        switch (s){
            case MONGO: return new LoginMongoService();
            case POSTGRESQL: return new LoginPostgresService();
        }
        return null;
    }

    private static Service createService(ServiceType s, Class clasS){
        switch (s){
            case MONGO:
                if(clasS.equals(Board.class)) return new BoardMongoService();
                if(clasS.equals(User.class)) return new UserMongoService();
            case POSTGRESQL:
                if(clasS.equals(Board.class)) return new BoardPostgresService();
                if(clasS.equals(User.class)) return new UserPostgresService();
        }
        return null;
    }

    private static ServiceType getServiceTypeProp(){
       return ServiceFactory.ServiceType
                .valueOf(Properties.getInstance()
                        .getProperty("UseConnection"));

    }


}
