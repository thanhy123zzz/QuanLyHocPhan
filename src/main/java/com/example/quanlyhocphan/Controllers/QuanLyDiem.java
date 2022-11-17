package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.DiemThi;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/QLDiem")
public class QuanLyDiem extends CommonController{
    @GetMapping("")
    public ModelAndView ViewListLopHP(){
        mv.clear();
        mv.addObject("ThongBao","Hi");
        mv.setViewName("QuanLy/ListLopHocPhan");
        List<LopHocPhan> list = lopHocPhanService.getListLopHocPhan(null);
        mv.addObject("ListLopHocPhan",list);
        mv.addObject("listNamHocHocKy",namHocHocKyService.getLisNamHoc());
        return mv;
    }
    @PostMapping("/load-listlophocphan")
    public ModelAndView loadListLopHocPhan(String dotHoc) throws ParseException {
        mv.clear();
        List<LopHocPhan> list = lopHocPhanService.getListLopHocPhan(dotHoc);
        mv.addObject("ListLopHocPhan",list);
        mv.setViewName("QuanLy/ListLopHocPhan :: #listLopHocPhan");
        return mv;
    }

    @GetMapping("/{MaLopHoc}")
    public ModelAndView ViewListDanhSachSVOfLop(@PathVariable("MaLopHoc") int MaLopHoc){
        mv.clear();
        List<DiemThi> list = diemThiService.getListDiemThi(MaLopHoc);
        mv.addObject("listSVofLopHoc",list);
        mv.setViewName("QuanLy/ListSVLopHoc");
        return mv;
    }
    @PostMapping("/{MaLopHoc}/insertdiem")
    public @ResponseBody Boolean InsertDiem(@PathVariable("MaLopHoc") int malop, String mssv, double diem){
        if(diem<0||diem>10){
            return false;
        }
        diemThiService.insertDiem(malop,mssv,diem);
        return true;
    }
}
