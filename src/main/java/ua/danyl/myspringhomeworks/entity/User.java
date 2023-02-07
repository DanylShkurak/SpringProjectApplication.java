package ua.danyl.myspringhomeworks.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
}
