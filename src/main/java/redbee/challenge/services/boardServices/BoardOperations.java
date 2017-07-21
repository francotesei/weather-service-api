package redbee.challenge.services.boardServices;

import redbee.challenge.models.Board;

import java.util.List;

/**
 * Created by ftesei on 19/07/17.
 */
public interface BoardOperations {
    public List<Board> loadBoardsUser(String userId) throws Exception;

    public void addBoardToFavorite(String userId, String boardId) throws Exception;

    public void removeBoardToFavorite(String userId, String boardId) throws Exception;
}
