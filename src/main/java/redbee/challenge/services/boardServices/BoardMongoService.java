package redbee.challenge.services.boardServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import redbee.challenge.YQL.WeatherApi;
import redbee.challenge.db.MongoConfiguration;
import redbee.challenge.db.MongoConnector;
import redbee.challenge.models.Board;
import redbee.challenge.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
public class BoardMongoService extends BoardBaseService {

    @Autowired
    private MongoConnector mongoService = new MongoConnector();

    @Override
    public Board findById(String id) throws Exception {

        mongoService.connect();
        Board board = mongoService.getMongoOperation()
                .findOne(new Query(Criteria
                        .where("id").is(id)),Board.class);


        mongoService.disconnect();
        return board;
    }

    public List<Board> findByName(String name) throws Exception {
        mongoService.connect();
        List<Board>  boards = mongoService.getMongoOperation()
                .find(new Query(Criteria
                        .where("name").is(name.toLowerCase())),Board.class);

        if(boards.size() == 0){
            boards = new ArrayList<>();
            WeatherApi.getBoardsByName(name,boards);
            saveBoards(boards);
            }
        return boards;
    }

    private void saveBoards(List<Board> boards) {
        mongoService.connect();
        for(Board board:boards)
            mongoService.getMongoOperation().save(board);
        mongoService.disconnect();
    }


    @Override
    public List<Board> findAll() {
        mongoService.connect();
        List<Board> list = mongoService.getMongoOperation().findAll(Board.class);
        mongoService.disconnect();
        return  list;
    }

    @Override
    public Board save(Board obj) {
        mongoService.connect();
        mongoService.getMongoOperation().save(obj);
        mongoService.disconnect();
        return obj;
    }

    @Override
    public Board update(Board obj) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public List<Board> loadBoardsUser(String userId) throws Exception {
        mongoService.connect();
        List<Board> boards = new ArrayList<>();
        User user = mongoService.getMongoOperation()
                .findOne(new Query(Criteria
                        .where("id").is(userId)),User.class);
        if(user != null){
            for(Board b:user.getBoards())
                boards.add(this.findById(b.getId()));
        }
        return boards;
    }

    public void addBoardToFavorite(String userId,String boardId) throws Exception {
        mongoService.connect();
        User user = mongoService.getMongoOperation()
                .findOne(new Query(Criteria
                        .where("id").is(userId)),User.class);
        if(user != null){
            Board board = this.findById(boardId);
            user.addNewBoard(true,new Board(board.getId()));
            mongoService.getMongoOperation().save(user);
        }
        mongoService.disconnect();
    }

    public void removeBoardToFavorite(String userId,String boardId){
        mongoService.connect();
        User user = mongoService.getMongoOperation()
                .findOne(new Query(Criteria
                        .where("id").is(userId)),User.class);
        if(user != null){
            user.deleteBoard(new Board(boardId));
            mongoService.getMongoOperation().save(user);
        }
        mongoService.disconnect();
    }



    public void save(List<Board> boards) {
    this.saveBoards(boards);
    }
}
