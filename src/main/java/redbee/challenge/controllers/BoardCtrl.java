package redbee.challenge.controllers;


import org.json.JSONException;
import org.springframework.web.bind.annotation.*;
import redbee.challenge.models.Board;
import redbee.challenge.services.boardServices.BoardService;
import redbee.challenge.services.Response;

import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
@RestController
@RequestMapping("/boards")
public class BoardCtrl {
private BoardService service;

@RequestMapping(value = "/{id}",method = RequestMethod.GET)
public Response getBoard(@PathVariable("id") String id) throws Exception {
    service = new BoardService();
        return new Response(service.findById(id), Response.ResponseStatus.OK);
    }


    @RequestMapping(value = "/byName",method = RequestMethod.GET)
    public Response getByName(@RequestParam("name") String name) throws Exception {
        service = new BoardService();
        return new Response(service.findByName(name), Response.ResponseStatus.OK);
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Board> getAll()  {
        service = new BoardService();
        return service.findAll();
    }
@RequestMapping(value = "/addBoardToFavorite",method = RequestMethod.GET)
public Response addBoardToFavorite(@RequestParam("username") String username , @RequestParam("board") String boardId) throws Exception {
        service = new BoardService();
        service.addBoardToFavorite(username,boardId);
        return new Response(new Board(boardId), Response.ResponseStatus.OK);
    }

    @RequestMapping(value = "/removeBoardToFavorite",method = RequestMethod.GET)
    public Response removeBoardToFavorite(@RequestParam("username") String username , @RequestParam("board") String boardId) throws Exception {
        service = new BoardService();
       service.removeBoardToFavorite(username,boardId);
        return new Response(new Board(boardId), Response.ResponseStatus.OK);
    }

    @RequestMapping(value = "/boardsUser",method = RequestMethod.GET)
    public Response getBoardsUser(@RequestParam("username") String username) throws Exception {
        service = new BoardService();
        return new Response(service.loadBoardsUser(username), Response.ResponseStatus.OK);

    }


}

