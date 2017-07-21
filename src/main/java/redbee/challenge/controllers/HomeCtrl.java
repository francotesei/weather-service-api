package redbee.challenge.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ftesei on 10/07/17.
 */
@RestController
@RequestMapping("/")
public class HomeCtrl {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayHelloWorld() {
        return "Welcome to Weather Service Api";
    }
}
