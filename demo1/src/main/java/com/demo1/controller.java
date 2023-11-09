package com.demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @RequestMapping("/user")
    public user getUser() {
        System.out.println("jdfnnf");
        return new user(1, "倪升武", "123456");
    }
}
