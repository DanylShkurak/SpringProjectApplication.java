package ua.danyl.myspringhomeworks.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.danyl.myspringhomeworks.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    @PostConstruct
    public void fillList() {
        users.add(new User(0, "Johni", 34, "Johni@mail", "1212123121"));
        users.add(new User(1, "Sasha", 18, "Sasha@mail", "1223432421"));
        users.add(new User(2, "Nick", 12, "Nick@mail", "1212123123"));
    }



    public List<User> getAll() {
        return users;
    }

    public User getById(int id) {
        return users.get(id);
    }

    public List<User> getByEmailAndPhone(String email, String phone) {

        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPhone().equals(phone))
                .toList();
    }

    public List<User> getByIdAndEmailAndPhone(Integer id, String email, String phone) {
        if (phone == null) {
            return users.stream()
                    .filter(user -> user.getId() == id)
                    .filter(user -> user.getEmail().equals(email))
                    .collect(Collectors.toList());
        } else
            return users.stream()
                    .filter(user -> user.getId() == id)
                    .filter(user -> user.getPhone().equals(phone))
                    .collect(Collectors.toList());


    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size() - 1);
        return user;
    }

    public User update(int id, User user) {
        User oldUser = users.get(id);
        oldUser.setAge(user.getAge());
        return users.get(id);
    }

    public int delete(int id) {
        users.remove(id);
        return id;
    }
}
