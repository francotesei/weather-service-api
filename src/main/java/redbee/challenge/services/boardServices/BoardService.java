package redbee.challenge.services.boardServices;
import org.springframework.beans.factory.annotation.Autowired;
import redbee.challenge.Properties;
import redbee.challenge.services.ServiceFactory;
import redbee.challenge.models.Board;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
public class BoardService extends BoardBaseService {

    @Autowired
    private BoardBaseService service = ServiceFactory.createServiceBoard();
    @Override
    public Board findById(String id) throws Exception {
        return  service.findById(id);
    }

    @Override
    public List<Board> findByName(String name) throws Exception {
        return service.findByName(name);
    }

    @Override
    public List<Board> findAll() {
        return service.findAll();
    }

    @Override
    public Board save(Board obj) {
        return service.save(obj);
    }

    @Override
    public void save(List<Board> list) {
        service.save(list);
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
        return service.loadBoardsUser(userId);
    }

    @Override
    public void addBoardToFavorite(String userId, String boardId) throws Exception {
        service.addBoardToFavorite(userId,boardId);
    }

    @Override
    public void removeBoardToFavorite(String userId, String boardId) throws Exception {
        service.removeBoardToFavorite(userId,boardId);
    }
}
