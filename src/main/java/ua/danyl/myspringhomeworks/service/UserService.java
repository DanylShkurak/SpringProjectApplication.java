package ua.danyl.myspringhomeworks.service;

import org.springframework.stereotype.Service;
import ua.danyl.myspringhomeworks.entity.User;
import ua.danyl.myspringhomeworks.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public List<User> getByEmailAndPhone(String email, String phone) {
        return userRepository.getByEmailAndPhone(email,phone);
    }

    public List<User> getByIdAndEmailAndPhone(Integer id, String email, String phone) {
        return userRepository.getByIdAndEmailAndPhone(id,email,phone);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(int id, User user) {
        return userRepository.update(id,user);
    }

    public int delete(int id) {
        return userRepository.delete(id);
    }
}
