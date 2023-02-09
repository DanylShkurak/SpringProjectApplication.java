package ua.danyl.myspringhomeworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.danyl.myspringhomeworks.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.phone =?2 where u.id=?1")
     Integer update(int id ,String phone);
 List<User> getByEmailAndPhone(String email, String phone);

    List<User> getByIdAndEmailOrPhone(Integer id, String email, String phone);
}
