package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.PhongHoc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        mv.setViewName("QuanLy/ThemLopHocPhan");
        List<PhongHoc> listPh = phongHocDao.getListPhongHoc();
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

    @PostMapping("/changesl")
    public @ResponseBody int SoLuongMax(int id, int sl){
        lopHocPhanService.doiMaxSV(id,sl);
        return dangKyLopHocPhanService.getqldk(id);
    }

    @PostMapping("/changeTT")
    public @ResponseBody String thaydoi(int id, Boolean tt){
        return lopHocPhanService.doiTrangThai(id,tt);
    }

    @GetMapping("/DK/{MaLop}")
    public ModelAndView ViewListSVDK(@PathVariable("MaLop") int MaLop){
        mv.clear();
        mv.setViewName("QuanLy/ListSVDK");
        List<DangKyLopHocPhan> list = dangKyLopHocPhanService.listSinhVienofLop(MaLop);
        mv.addObject("listSVofLopHoc",list);
        return mv;
    }
    @GetMapping("/sua/{maLop}")
    public ModelAndView ViewSuaLopHocPhan(@PathVariable("maLop") int maLop){
        mv.clear();
        mv.addObject("Lop",lopHocPhanService.getLopHocPhan(maLop));
        List<PhongHoc> listPh = phongHocDao.getListPhongHoc();
        mv.addObject("listDotHoc",namHocHocKyService.getLisNamHoc());
        mv.addObject("listLichHoc",lichHocService.getListLicHoc());
        mv.addObject("listGiaoVien",giaoVienDao.getListGiaoVien());
        mv.addObject("listPhong",listPh);
        mv.addObject("listHocPhan",hocPhanService.getListHocPhan(null));
        mv.setViewName("QuanLy/SuaLopHocPhan");
        return mv;
    }
    @PostMapping("/sua")
    public String Sua(LopHocPhan lopHocPhan,int mahocPhan, String dotHocstr){
        lopHocPhan.setHocPhan(new HocPhan(mahocPhan));
        lopHocPhanService.SuaLopHocPhan(lopHocPhan,dotHocstr);
        return "redirect:/QLLopHocPhan";
    }
}
