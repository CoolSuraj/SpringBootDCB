package com.dcb.SpringBootTutorial.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//For Normal MVC we can use
//@Controller

//For Rest Controller use @RestController // this returns @ResponseBody
//it is combination of @Controller and @ResponseBody
@RestController
public class HelloController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    //we can also use @GetMapping("/")
    public String helloWorld(){
        return  "Hello World !";
    }
}
