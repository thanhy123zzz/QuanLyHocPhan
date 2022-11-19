package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.QuanLy;
import com.example.quanlyhocphan.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HocPhanController extends CommonController{
    @Autowired
    private EmailService emailService;
    @GetMapping("/")
    public String Index(HttpSession session, Principal principal){
        if(accountsDao.checkAccount(principal.getName()).getMaRole().equals("RL01")){
            session.setAttribute("user",sinhVienService.getSinhVien(principal.getName()));
        }
        else {
            QuanLy quanLy = quanLyDao.getQLbyAccount(principal.getName());
            quanLy.setAccounts(accountsDao.checkAccount(principal.getName()));
            session.setAttribute("user",quanLy);
        }
        return "Index1";
    }
}
