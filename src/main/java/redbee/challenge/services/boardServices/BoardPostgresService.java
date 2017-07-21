package redbee.challenge.services.boardServices;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import redbee.challenge.YQL.WeatherApi;
import redbee.challenge.db.PostgresConnector;
import redbee.challenge.models.Board;
import redbee.challenge.models.Forecast;
import redbee.challenge.models.User;
import redbee.challenge.services.Service;
import redbee.challenge.services.ServiceFactory;
import redbee.challenge.services.boardServices.BoardBaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
public class BoardPostgresService extends BoardBaseService {
    private PostgresConnector postgresConnector = new PostgresConnector();
    @Override
    public Board findById(String id) throws Exception {
        postgresConnector.connect();
        Board board = (Board) postgresConnector.getOperations().get(Board.class,id);
        postgresConnector.disconnect();
        return board;
    }

    @Override
    public List<Board> findByName(String name) throws Exception {
      postgresConnector.connect();
        Query query = postgresConnector.getOperations().createQuery("FROM User where name = :name");
        query.setParameter("name",name);
        List<Board> boards = query.list();
        postgresConnector.disconnect();
        if(boards == null || boards.size() == 0){
            boards = new ArrayList<>();
            WeatherApi.getBoardsByName(name,boards);
            save(boards);
        }
        return boards;
    }

    @Override
    public List<Board> findAll() {
        postgresConnector.connect();
        List<Board> boards = postgresConnector.getOperations().createCriteria(Board.class).list();
        postgresConnector.disconnect();
        return boards;
    }

    @Override
    public Board save(Board obj) {

        postgresConnector.connect();
        postgresConnector.beginTransaction();
        postgresConnector.getOperations().save(obj);
        postgresConnector.commit();
        postgresConnector.disconnect();
        return obj;
    }

    @Override
    public void save(List<Board> list) {
        postgresConnector.connect();
        postgresConnector.beginTransaction();
        for (Board board:list)
            postgresConnector.getOperations().saveOrUpdate(board);
        postgresConnector.commit();
        postgresConnector.disconnect();

    }

    @Override
    public Board update(Board obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Board> loadBoardsUser(String userId) throws Exception {
     Service service = ServiceFactory.createServiceUser();
     User user  = (User) service.findById(userId);
        return user.getBoards();
    }



    @Override
    public void addBoardToFavorite(String userId, String boardId) throws Exception {
        Service serviceUser = ServiceFactory.createServiceUser();
        Service serviceBoard = ServiceFactory.createServiceBoard();
        User user = (User) serviceUser.findById(userId);
        if( user != null){
            user.addNewBoard(true, (Board) serviceBoard.findById(boardId));
            postgresConnector.connect();
            postgresConnector.beginTransaction();
            postgresConnector.getOperations().update(user);
            postgresConnector.commit();
            postgresConnector.disconnect();

        }
    }

    @Override
    public void removeBoardToFavorite(String userId, String boardId) throws Exception {
        Service serviceUser = ServiceFactory.createServiceUser();
        User user = (User) serviceUser.findById(userId);
        if( user != null){
            user.deleteBoard(new Board(boardId));
            postgresConnector.connect();
            postgresConnector.beginTransaction();
            postgresConnector.getOperations().update(user);
            postgresConnector.commit();
            postgresConnector.disconnect();
        }

    }
}