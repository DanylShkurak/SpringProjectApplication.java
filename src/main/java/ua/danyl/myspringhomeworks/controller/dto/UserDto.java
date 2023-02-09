package ua.danyl.myspringhomeworks.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.danyl.myspringhomeworks.entity.User;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
}
