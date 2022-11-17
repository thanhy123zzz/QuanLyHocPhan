package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        List<DangKyLopHocPhan> list = dangKyLopHocPhanService.listSinhVienofLop(MaLopHoc);
        mv.addObject("listSVofLopHoc",list);
        mv.setViewName("QuanLy/ListSVLopHoc");
        return mv;
    }
}
