package com.sachin.Rest.Webservices.restful_web_services.Users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {


    private static List<User> users = new ArrayList<>();
private static int usercount=0;

    static{
        users.add(new User(++usercount,"sachin", LocalDate.now().minusYears(30)));
        users.add(new User(++usercount,"kumar", LocalDate.now().minusYears(20)));
        users.add(new User(++usercount,"singh", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usercount);
        users.add(user);
        return user;
    }

    public User findOne(int id){

        Predicate<? super User> predicate= user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}

