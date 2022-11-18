package com.example.quanlyhocphan.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController extends CommonController{
    
    @GetMapping("/sinhvien")
    public ModelAndView Home(){

        return mv;
    }
    /* Học phần */
    @GetMapping("/Student/khoa")
    public ModelAndView KhoaHocPhan(){
        mv.setViewName("SinhVien/Khoa");
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }

    @GetMapping("/Student/Hocphan/{MaKhoa}")
    public ModelAndView ListHocPhanOfKhoa(@PathVariable("MaKhoa") String MaKhoa){
        mv.setViewName("SinhVien/ListHocPhan");
        mv.addObject("Khoa",khoaService.getKhoa(MaKhoa));
        mv.addObject("ListHocPhanOfKhoa", hocPhanService.getListHocPhan(MaKhoa));
        return mv;
    }
    /* End */

    /* Điểm */
    /* End */

    /* Lịch học */
    /* End */


}
