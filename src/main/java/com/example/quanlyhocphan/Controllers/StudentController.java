package com.example.quanlyhocphan.Controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.MessageHandler.Partial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import com.example.quanlyhocphan.Entities.SinhVien;

@RequestMapping("/sinhvien")
@Controller
public class StudentController extends CommonController{
    
    @GetMapping("")
    public ModelAndView Home(){
        return mv;
    }
    /* Học phần */
    @GetMapping("/khoa")
    public ModelAndView KhoaHocPhan(){
        mv.setViewName("SinhVien/Khoa");
        mv.addObject("listKhoa",khoaService.getListKhoa());
        return mv;
    }

    @GetMapping("/Hocphan/{MaKhoa}")
    public ModelAndView ListHocPhanOfKhoa(@PathVariable("MaKhoa") String MaKhoa){
        mv.setViewName("SinhVien/ListHocPhan");
        mv.addObject("Khoa",khoaService.getKhoa(MaKhoa));
        mv.addObject("ListHocPhanOfKhoa", hocPhanService.getListHocPhan(MaKhoa));
        return mv;
    }

    @GetMapping("/DangkyHP")
    public ModelAndView ShowDangKy(Principal principal){
        mv.clear();
        mv.setViewName("SinhVien/LopHocPhan");
        List<LopHocPhan> list = lopHocPhanService.getListByMaSVandMaCN(principal.getName());
        mv.addObject("ListLopHocPhan",list);
        System.out.println(principal.getName());
        return mv;
    }

    @GetMapping("/DangKyHP/{maLop}")
    public ModelAndView ChitietDangky(@PathVariable("maLop") Integer maLop){
        mv.setViewName("SinhVien/ChitietLopHP");
        LopHocPhan lop = lopHocPhanService.getLopHocPhan(maLop);
        mv.addObject("lop",lop);
        return mv;
    }
    @PostMapping("/DangKyHP/confirm")
    public ModelAndView confirmDK(String maLop,Date dothoc,Principal principal){
        // DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        // String currentDateTime = dateFormatter.format(new Date());
        DangKyLopHocPhan dk = new DangKyLopHocPhan();
        NamHocHocKy nh = new NamHocHocKy();
        SinhVien sv = new SinhVien();
        LopHocPhan lp = new LopHocPhan();
        lp.setMaLop(Integer.parseInt(maLop));
        sv.setMaSV(principal.getName());
        nh.setDotHoc(dothoc);
        dk.setNamHocHocKy(nh);
        dk.setNgayDangKy(new java.util.Date());
        dk.setSinhVien(sv);
        dk.setLopHocPhan(lp);
        int insert = dangKyLopHocPhanService.insert(dk);
        if(insert > 0){
            System.out.println("Đăng ký thành công!");
            mv.addObject("messTC", "1");
        }else{
            System.out.println("Đăng ký thất bại");
            mv.addObject("messTC", "2");
        }
        mv.setViewName("redirect:/sinhvien/DangkyHP");
        return mv;
    }

    @GetMapping("/checkDK")
    public @ResponseBody boolean checkDK(String name, String malop){
        return dangKyLopHocPhanService.checkSVDKHP(name, malop);
    }
    /* End */

    /* Chương trình đào tạo */
    @GetMapping("/CTDT")
    public ModelAndView listCTDT(Principal principal){
        List<HocPhanCTDT> list = hocPhanCTDTService.getListByMaSV(principal.getName());
        mv.addObject("listCTDT", list);
        mv.addObject("cn", chuyenNganhService.getCNByMaSV(principal.getName()));
        mv.setViewName("SinhVien/CTDT");
        return mv;
    }
    /* End */

    /* Điểm */
    @GetMapping("/Diem")
    public ModelAndView listDiem(Principal principal){
        mv.addObject("listDiem", diemThiService.getDiemThiByMaSV(principal.getName()));
        mv.setViewName("SinhVien/Diem");
        return mv;
    }
    /* End */

    /* Lịch học */
    @GetMapping("/LichHoc")
    public ModelAndView ListLichHocCaNhan(Principal principal){
        // mv.addObject("listlich", lichHocService.getLisLichHocs(principal.getName()));
         mv.addObject("listlich",lopHocPhanService.getListLopHocPhansByMaSV(principal.getName()));
        mv.addObject("listDK", namHocHocKyService.getListByMaSVCN(principal.getName()));
        mv.setViewName("SinhVien/ListLichHoc");
        return mv;
    }

    @PostMapping("/listlophocphan")
    public ModelAndView listlophocphan(String dotHoc,Principal principal){
        mv.clear();
        mv.addObject("listlich",lopHocPhanService.getListLopHocPhanByDotHoc(dotHoc,principal.getName()));
        mv.setViewName("SinhVien/ListLichHoc :: #listLopHocPhan");
        return mv;
    }
    /* End */


}
