package com.example.quanlyhocphan.Controllers;

import java.security.Principal;
import java.util.List;

import javax.websocket.MessageHandler.Partial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.quanlyhocphan.Entities.HocPhanCTDT;

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

    /* Chương trình đào tạo */
    @GetMapping("/Student/CTDT")
    public ModelAndView listCTDT(Principal principal){
        List<HocPhanCTDT> list = hocPhanCTDTService.getListByMaSV(principal.getName());
        mv.addObject("listCTDT", list);
        mv.addObject("cn", chuyenNganhService.getCNByMaSV(principal.getName()));
        mv.setViewName("SinhVien/CTDT");
        return mv;
    }
    /* End */

    /* Điểm */
    /* End */

    /* Lịch học */
    /* End */


}
