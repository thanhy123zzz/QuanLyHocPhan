package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Service.KhoaService;
import com.example.quanlyhocphan.Service.ServiceImp.AccountDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

public class CommonController {
    @Autowired
    public PasswordEncoder passwordEncoder;
    ModelAndView mv = new ModelAndView();
    @Autowired
    KhoaService khoaService;
    @Autowired
    AccountDetailService accountDetailService;
}
