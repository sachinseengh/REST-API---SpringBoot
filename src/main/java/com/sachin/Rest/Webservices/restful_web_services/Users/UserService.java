package com.sachin.Rest.Webservices.restful_web_services.Users;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserService {
private UserDAOService service;

    public UserService(UserDAOService service) {
        this.service = service;
    }

    @GetMapping(path="/users")
    public List<User> getUsers(){
    return service.findAll();
    }

    @GetMapping(path="/users/{id}")
    public User getuser(@PathVariable Integer id){
        return service.findOne(id);
    }
    @PostMapping (path="/users")
    public Void createUser(@RequestBody User user){
       service.save(user);
        return null;
    }
}
