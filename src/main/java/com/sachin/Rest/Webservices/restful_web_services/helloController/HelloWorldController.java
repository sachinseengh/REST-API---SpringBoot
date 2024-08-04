package com.sachin.Rest.Webservices.restful_web_services.helloController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(method= RequestMethod.GET,path="/hello-world")
    public String helloWorld(){
        return "Hello World sachin singh ";
    }
}
