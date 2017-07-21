package redbee.challenge.controllers;


import org.springframework.web.bind.annotation.*;
import redbee.challenge.models.Token;
import redbee.challenge.services.*;
import redbee.challenge.services.loginServices.LoginService;


/**
 * Created by ftesei on 13/07/17.
 */
@RestController
@RequestMapping("/login")
public class LoginCtrl {
    private LoginService service;

    @RequestMapping(value = "/singUp",method = RequestMethod.GET)
    public Response singUp(@RequestParam("username") String username , @RequestParam("pass") String pass) throws Exception {
        service = new LoginService();
        Token token = service.singUp( username, pass);
        if(token == null)
            return new Response("El Usuario "+username+ " ya existe.", Response.ResponseStatus.ERROR);
        return new Response(token,Response.ResponseStatus.OK);

    }
    @RequestMapping(value = "/singIn",method = RequestMethod.GET)
    public Response singIn(@RequestParam("username") String username , @RequestParam("pass") String pass) throws Exception {
        service = new LoginService();
        Token token = service.singIn( username, pass);
        if(token == null)
            return new Response("El Usuario "+username+ " No existe.", Response.ResponseStatus.ERROR);
        return new Response(token,Response.ResponseStatus.OK);
    }

    @RequestMapping(value = "/validateSession",method = RequestMethod.GET)
    public Response validateSession(@RequestParam("username") String username , @RequestParam("token") String tokenId) throws Exception {
        service = new LoginService();
        Token token = service.validateSession(username,tokenId);
        if(token == null)
            return new Response("La session expiro.", Response.ResponseStatus.ERROR);
        return new Response(token,Response.ResponseStatus.OK);

    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Response logout(@RequestParam("username") String username) throws Exception {
        service = new LoginService();
         service.logout(username);
         return new Response(new Token(), Response.ResponseStatus.OK);

    }


}
