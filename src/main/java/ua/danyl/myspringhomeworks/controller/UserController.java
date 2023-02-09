package ua.danyl.myspringhomeworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.danyl.myspringhomeworks.controller.dto.IntegerDto;
import ua.danyl.myspringhomeworks.controller.dto.UserDto;
import ua.danyl.myspringhomeworks.controller.mapper.UserMapper;
import ua.danyl.myspringhomeworks.entity.User;
import ua.danyl.myspringhomeworks.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(
                userService.getAll()
                        .stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList())
                , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(userMapper.toDto(userService.getById(id)));
    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<List<User>> getByEmailAndPhone(
            @PathVariable String email,
            @PathVariable String phone
    ) {
        return ResponseEntity.ok(userService.getByEmailAndPhone(email, phone));
    }

    @GetMapping("/filter/")
    public ResponseEntity<List<UserDto>> getByIdAndEmailOrPhone(
            @RequestParam Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone
    ) {
        return ResponseEntity.ok(userService.getByIdAndEmailOrPhone(id, email, phone)
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return  new ResponseEntity<>(userMapper.toDto(
                userService.save(
                        userMapper.toEntity(userDto))),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{phone}")
    public ResponseEntity<IntegerDto> update(@PathVariable int id, @PathVariable String phone) {
        return new ResponseEntity<>(new IntegerDto(userService.update(id,phone)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IntegerDto> delete(@PathVariable int id) {
        return ResponseEntity.ok(new IntegerDto(userService.delete(id)));
    }
}
