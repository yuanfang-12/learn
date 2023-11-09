package com.bocsoft.controller;

import com.bocsoft.annotation.Aopdemo;
import com.bocsoft.entity.FuncEntity;
import com.bocsoft.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Value("${demo.param.data}")
    private String d;

    @Autowired
    private DemoService demoService;


    @Autowired
    private DataFile dataFile;

    @RequestMapping("func")
    public String func(){
        return "hello world";
    }

    @RequestMapping("param")
    public String param(){
        return d;
    }

    @RequestMapping("param/file")
    public String file(){
        String a = dataFile.getCount();
        String b = dataFile.getAll();
        String c = dataFile.getPort();

        return "count: "+ a + ";all:" + b + ";port:" + c;
    }

    @RequestMapping("path/{id}")
    public String path(@PathVariable String id){
        return id;
    }
    //@PathVariable

    @RequestMapping("headdata")
    public String head(@RequestHeader("uuid") String uuid){
        return uuid;
    }

    @RequestMapping("getcookie")
    public String cookie(@CookieValue("id") String id){
        return id;
    }

    @RequestMapping("getparam")
    public String param(@RequestParam("a") String a, @RequestParam("b") int b){
        return "a:"+ a + ";b:" + b;
    }
    //@RequestParam

    @RequestMapping(value = "getbody", method = RequestMethod.POST)
    public String body(@RequestBody String abc){
        return abc;
    }

    @RequestMapping("beforepoint")
    @Aopdemo
    public String before(){
        System.out.println("run");
        return "b";
    }

    @RequestMapping("exe")
    public String execution(){
        System.out.println("exe run");
        return "a";
    }

    @RequestMapping("exception")
    public String exce() throws Exception{
        throw new Exception("throw");
    }

    @RequestMapping("attr")
    public Date attr(@ModelAttribute("all") Date all){
        return all;
    }

    @RequestMapping("select/{name}")
    public FuncEntity select(@PathVariable String name){
        return demoService.getByName(name);
    }

}
