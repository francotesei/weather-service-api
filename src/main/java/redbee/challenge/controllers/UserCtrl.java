package redbee.challenge.controllers;

import org.springframework.web.bind.annotation.*;
import redbee.challenge.models.User;
import redbee.challenge.services.userServices.UserService;

import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
@RestController
@RequestMapping("/users")
public class UserCtrl {

    private UserService service ;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public User post(@ModelAttribute User user ) {
        service = new UserService();
        service.save(user);
        return user;
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getAll()  {
        service = new UserService();
        return service.findAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User get(@PathVariable("id") String id) throws Exception {
        service = new UserService();
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User put( @PathVariable("id") String id ,@RequestBody User user)  {
        user.setId(id);
        service = new UserService();
        return service.update(user);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id)  {
        service = new UserService();
        service.delete(id);
        return  id;
    }






}
