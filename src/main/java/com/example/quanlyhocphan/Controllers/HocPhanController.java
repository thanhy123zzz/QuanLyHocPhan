package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HocPhanController {
    @Autowired
    private EmailService emailService;
    @GetMapping("/")
    public String Index(){
        return "Index1";
    }
}
