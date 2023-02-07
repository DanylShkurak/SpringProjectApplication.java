package ua.danyl.myspringhomeworks.repository;

import org.springframework.stereotype.Repository;
import ua.danyl.myspringhomeworks.entity.User;

import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAll(){
        return List.of(
                new User(1,"Sasha",18),
                new User(2,"Nick",12)
        );
    }
}
