package com.sachin.Rest.Webservices.restful_web_services.helloController;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    @RequestMapping(method= RequestMethod.GET,path="/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello World  ";
    }


//    usually the response request mapping get is in json format so
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorld2(){
        return new HelloWorldBean("Hello world");
    }


    @GetMapping(path="/hello-path-variable/{name}")
    public HelloWorldBean hellopathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello,%s",name));
    }
}
