package com.sachin.Rest.Webservices.restful_web_services.Users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.function.Predicate;

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
        User one = service.findOne(id);
        if(one==null){
            throw new UserNotFoundException("id "+id);
        }
        return one;
    }

    @PostMapping (path="/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
     User savedUser =  service.save(user);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId())
               .toUri();
        ResponseEntity<Object> build = ResponseEntity.created(location).build();
        return build;
    }



    @DeleteMapping (path="/users/{id}")
    public User deleteuser(@PathVariable Integer id){
        User one = service.deleteById(id);
        if(one==null){
            throw new UserNotFoundException("id "+id);
        }
        return one;
    }
}

