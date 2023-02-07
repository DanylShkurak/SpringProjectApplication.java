package ua.danyl.myspringhomeworks.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ua.danyl.myspringhomeworks.entity.User;
import ua.danyl.myspringhomeworks.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll(){
        return userService.getAll();
    }
}
