package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class CtdtController extends CommonController{
    @GetMapping("/QL/ctdt")
    public ModelAndView ViewCTDT(){
        mv.setViewName("QuanLy/CTDT");
        mv.addObject("listNamHocHocKy",namHocHocKyService.getLisNamHoc());
        mv.addObject("listCN",chuyenNganhService.getListCN());
        return mv;
    }
    @GetMapping("/QL")
    public ModelAndView ViewListCTDT(){
        mv.setViewName("QuanLy/ListCTDT");
        mv.addObject("listCTDT",ctdtService.getListCTDT());
        return mv;
    }
    @GetMapping("/QL/{maCTDT}")
    public ModelAndView ViewListDetailCTDT(@PathVariable("maCTDT") String maCTDT){
        List<HocPhanCTDT> list = hocPhanCTDTService.getListByMaCTDT(maCTDT);
        mv.addObject("listCTDT", list);
        mv.addObject("cn", ctdtService.getCTDT(maCTDT).getChuyenNganh());
        mv.setViewName("SinhVien/CTDT");
        return mv;
    }
    @PostMapping("QL/check")
    public @ResponseBody Boolean checkCTDT(String maCTDT){
        if(maCTDT.equals("")) return false;
        if(ctdtService.getCTDT(maCTDT)==null){
            return false;
        }
        return true;
    }
    @PostMapping("/QL/insert")
    public String insertCTDT(CTDT ctdt,@RequestParam("fileExcel")MultipartFile fileExcel,String DotHoc){
        String kq = ctdtService.insertCTDT(ctdt, DotHoc);
        if(kq.contains("Thành công")) {
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(fileExcel.getInputStream());
                XSSFSheet sheet = workbook.getSheetAt(0);
                HocPhanCTDT hocPhanCTDT = new HocPhanCTDT();
                hocPhanCTDT.setCtdt(new CTDT(ctdt.getMaCTDT()));
                for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                    XSSFRow row = sheet.getRow(i);
                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

                        double d = Double.parseDouble(row.getCell(j).toString());
                        hocPhanCTDT.setHocPhan(new HocPhan((int)d));
                        hocPhanCTDTService.InsertHocPhanCTDT(hocPhanCTDT);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "redirect:/QL";
    }
}
