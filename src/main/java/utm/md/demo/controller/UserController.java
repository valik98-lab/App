package utm.md.demo.controller;

import utm.md.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {

    @GetMapping
    public  User test(){
      User user = new User("User","user");
    return user;
    }

}
