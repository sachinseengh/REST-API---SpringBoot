package com.sachin.Rest.Webservices.restful_web_services.helloController;

public class HelloWorldBean {
private String message;

    public HelloWorldBean(String message){
            this.message= message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBen{" +
                "message='" + message + '\'' +
                '}';
    }
}
