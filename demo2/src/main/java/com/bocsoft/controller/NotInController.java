package com.bocsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NotInController {

    @Autowired(required = false)
    private DemoController demoController;

    public void init(){
        System.out.println("init controller");
    }

    public void des(){
        System.out.println(demoController.getClass().getName());
    }
}
