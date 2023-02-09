package ua.danyl.myspringhomeworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.danyl.myspringhomeworks.entity.User;
import ua.danyl.myspringhomeworks.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

      public User getById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getByEmailAndPhone(String email, String phone) {
        return userRepository.getByEmailAndPhone(email, phone);
    }

    public List<User> getByIdAndEmailOrPhone(Integer id, String email, String phone) {
        return userRepository.getByIdAndEmailOrPhone(id, email, phone);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Integer update(int id, String phone) {
        return userRepository.update(id, phone);
    }

    public int delete(int id) {
        userRepository.deleteById(id);
        return id;
    }
}
