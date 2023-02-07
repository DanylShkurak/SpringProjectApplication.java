package ua.danyl.myspringhomeworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.danyl.myspringhomeworks.configuration.SpringConfiguration;
import ua.danyl.myspringhomeworks.controller.UserController;
import ua.danyl.myspringhomeworks.entity.User;

import java.util.List;


@SpringBootApplication
public class SpringProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
        UserController userController = context.getBean(UserController.class);
        List<User> all = userController.getAll();
        all.forEach(System.out::println);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        String pathBean = context.getBean("pathBean", String.class);
//        System.out.println("Hello World");
//        System.out.println(pathBean);
//        User user = context.getBean("getUser", User.class);
//        user.setAge(12);
//        User user2 = context.getBean("getUser", User.class);
//        System.out.println(user);
//        System.out.println(user2);
//        System.out.println(context.getBean("getTableName", String.class));

    }

}
