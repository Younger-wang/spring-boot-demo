package com.wyg.helloworld.controller;

import com.wyg.helloworld.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @Autowired
    private Person person;

    @Autowired
    private Person2 person2;

    @Autowired
    private Person3 person3;

    @Autowired
    private Person4 person4;

    @Autowired
    private Person5 person5;

    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello world";
    }

    @GetMapping("/person")
    public Person getPerson(){
        return person;
    }

    @GetMapping("/person2")
    public Person2 getPerson2(){
        return person2;
    }

    @GetMapping("/person3")
    public Person3 getPerson3(){
        return person3;
    }

    @GetMapping("/person4")
    public Person4 getPerson4(){
        return person4;
    }

    @GetMapping("/person5")
    public Person5 getPerson5(){
        return person5;
    }
}
