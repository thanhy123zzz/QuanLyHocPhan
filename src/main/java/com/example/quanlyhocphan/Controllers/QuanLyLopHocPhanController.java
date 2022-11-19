package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.PhongHoc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/QLLopHocPhan")
@Controller
public class QuanLyLopHocPhanController extends CommonController{
    @GetMapping("")
    public ModelAndView ViewListLopHocPhan(){
        mv.clear();
        mv.setViewName("QuanLy/ListLopHocPhan");
        List<LopHocPhan> list = lopHocPhanService.getListLopHocPhan("full");
        mv.addObject("bien",false);
        mv.addObject("ListLopHocPhan",list);

        return mv;
    }
    @GetMapping("/them")
    public ModelAndView ViewinsertLopHocPhan(){
        mv.clear();
        List<PhongHoc> listPh = phongHocDao.getListPhongHoc();
        mv.setViewName("QuanLy/ThemLopHocPhan");
        mv.addObject("listDotHoc",namHocHocKyService.getLisNamHoc());
        mv.addObject("listLichHoc",lichHocService.getListLicHoc());
        mv.addObject("listGiaoVien",giaoVienDao.getListGiaoVien());
        mv.addObject("listPhong",listPh);
        mv.addObject("listHocPhan",hocPhanService.getListHocPhan(null));
        return mv;
    }
    @PostMapping("/them")
    public String insertLopHocPhan(LopHocPhan lopHocPhan,int mahocPhan, String dotHocstr){
        mv.clear();
        lopHocPhan.setHocPhan(new HocPhan(mahocPhan));
        lopHocPhan.setMaxSV(phongHocDao.getPhongHoc(lopHocPhan.getPhongHoc().getMaPhong()).getSoGhe());
        lopHocPhanService.insertLopHocPhan(lopHocPhan,dotHocstr);
        return "redirect:/QLLopHocPhan";
    }

    @GetMapping("/sl")
    public @ResponseBody int sl(int malop){
        return dangKyLopHocPhanService.getqldk(malop);
    }
}
