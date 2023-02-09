package ua.danyl.myspringhomeworks.controller.mapper;

import org.springframework.stereotype.Component;
import ua.danyl.myspringhomeworks.controller.dto.UserDto;
import ua.danyl.myspringhomeworks.entity.User;
@Component
public class UserMapper {
    public UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getEmail(),
                user.getPhone()
        );
    }
    public User toEntity(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getAge(),
                userDto.getEmail(),
                userDto.getPhone()
        );
    }
}
