package com.bocsoft;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({java.lang.Exception.class})
    @ResponseBody
    public String exceptionH(Exception e){
        System.out.println("exception");
        return "error: " + e.getMessage();
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-mm-dd"));
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("all", new Date());
    }

}
