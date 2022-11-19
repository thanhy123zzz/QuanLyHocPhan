package com.example.quanlyhocphan.Controllers;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.quanlyhocphan.Entities.Accounts;
import com.example.quanlyhocphan.Service.EmailService;

@Controller
public class LogInController extends CommonController {

    // @GetMapping("/login")
    // public ModelAndView Login(){
    // ModelAndView mav = new ModelAndView();
    // mav.setViewName("login");
    // return mav;
    // }

    @GetMapping("/login")
    public ModelAndView lLogin(String success) {
        ModelAndView mav = new ModelAndView();
        mv.setViewName("login");
        return mav;
    } 
    // @PostMapping("/j_spring_security_check")
    // public ModelAndView lLoginFail(String success) {
    //     ModelAndView mav = new ModelAndView();
    //     mv.addObject("TaiKhoan", "");
    //     // if (Objects.equals(success, "fail")) {
    //     //     // System.out.println("Đăng nhập thất bại");
    //     //     // mv.addObject("messageSend", "Đăng nhập thất bại");
    //     // }
    //     mv.setViewName("login");
    //     return mav;
    // }

    @Autowired
    private EmailService emailService;

    // Sending a simple Email @RequestParam("gmail")
    @PostMapping("/sendMail")
    public ModelAndView sendMail(@RequestParam("gmail") String gmail,HttpSession session) {
        String code = emailService.sendSimpleMail(gmail);
        session.setAttribute("GMAIL", gmail);
        session.getAttribute("CODE");
        session.removeAttribute("CODE");
        session.setAttribute("CODE", code);
        String x =  (String) session.getAttribute("CODE");
        System.out.println(x);
        // mv.addObject("CODECF", code);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login :: #codeSession");
        return mv;
    }
    @PostMapping("/changepass")
    public ModelAndView changePass(@RequestParam("password") String password,HttpSession session){
        String email = (String)session.getAttribute("GMAIL");
        String endcodePass = passwordEncoder.encode(password);
        Accounts ac = accountDetailService.getListByEmailEdu(email).get(0);
        int x = accountDetailService.updatePassWord(endcodePass, ac.getTaiKhoan());
        if(x>0){
            mv.setViewName("login");
            return mv;
        }else{
            mv.setViewName("error");
            return mv;
        }
    }

    @GetMapping("/403")
    public String Page403(){
        return "403";
    }
}
