package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.Khoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/QLHocPhan")
public class QuanLyHocPhanController extends CommonController{
    @GetMapping("/khoa")
    public ModelAndView KhoaHocPhan(){
        mv.setViewName("QuanLy/Khoa");
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }
    @GetMapping("/{MaKhoa}")
    public ModelAndView ListHocPhanOfKhoa(@PathVariable("MaKhoa") String MaKhoa){
        mv.setViewName("QuanLy/ListHocPhan");
        mv.addObject("Khoa",khoaService.getKhoa(MaKhoa));
        mv.addObject("ListHocPhanOfKhoa", hocPhanService.getListHocPhan(MaKhoa));
        return mv;
    }
    @GetMapping("/them")
    public ModelAndView ViewThemHocPhan(){
        mv.setViewName("QuanLy/ThemHocPhan");
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }
    @PostMapping("/them")
    public String InsertHocPhan(HocPhan hocPhan, String maKhoa){
        hocPhan.setKhoa(new Khoa(maKhoa));
        hocPhanService.insertHocPhan(hocPhan);

        return "redirect:/QLHocPhan/"+maKhoa;
    }

    @GetMapping("/sua/{MaHP}")
    public ModelAndView ViewSuaHocPhan(@PathVariable("MaHP") int MaHP){
        mv.setViewName("QuanLy/SuaHocPhan");
        mv.addObject("HocPhan",hocPhanService.getHocPhan(MaHP));
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }
    @PostMapping("/sua")
    public String UpdateHocPhan(HocPhan hocPhan){
        hocPhanService.updateHocPhan(hocPhan);
        return "redirect:/QLHocPhan/"+hocPhan.getKhoa().getMaKhoa();
    }

}
