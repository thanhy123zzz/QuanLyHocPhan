package com.example.quanlyhocphan.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogInController extends Common{
    
    // @GetMapping("/login") 
    // public ModelAndView Login(){
    // ModelAndView mav = new ModelAndView();
    //     mav.setViewName("login");
    //     return mav;
    // }

    @GetMapping("/login") 
    public ModelAndView lLogin(){
    ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
