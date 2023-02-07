package ua.danyl.myspringhomeworks.controller;

import org.springframework.web.bind.annotation.*;
import ua.danyl.myspringhomeworks.entity.User;
import ua.danyl.myspringhomeworks.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping("/{email}/{phone}")
    public List<User> getByEmailAndPhone(
            @PathVariable String email,
            @PathVariable String phone
    ) {
        return userService.getByEmailAndPhone(email, phone);
    }

    @GetMapping("/filter")
    public List<User> getByIdAndEmailAndPhone(
            @RequestParam Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone
    ) {
        return userService.getByIdAndEmailAndPhone(id, email, phone);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id){
      return userService.delete(id);
    }
}
