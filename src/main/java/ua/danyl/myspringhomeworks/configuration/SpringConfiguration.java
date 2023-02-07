package ua.danyl.myspringhomeworks.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.danyl.myspringhomeworks.entity.User;

@Configuration
@ComponentScan(value = "ua.danyl.myspringhomeworks.configuration")
@PropertySource("classpath:application.properties")
public class SpringConfiguration {
    @Value("${connection.info")
    private String infoOfConnection;
    @Value("${table.name}")
    private String  tableName;

    @Bean
    public String pathBean(){
        return "connect path";
    }
    @Bean
    public String getTableName(){
        return tableName;
    }
    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User(0, "Johni", 34,"Johni@mail","1212123121");
    }
    @Bean
    public String getInfoOfConnection(){
        return infoOfConnection;
    }
}
