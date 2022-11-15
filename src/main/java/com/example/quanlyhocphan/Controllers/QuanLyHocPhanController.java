package com.example.quanlyhocphan.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/QLHocPhan")
public class QuanLyHocPhanController extends CommonController{
    @GetMapping("/khoa")
    public ModelAndView KhoaHocPhan(){
        mv.setViewName("QuanLy/Khoa");
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }
}
