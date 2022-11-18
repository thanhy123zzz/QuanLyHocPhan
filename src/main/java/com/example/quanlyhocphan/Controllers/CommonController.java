package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Service.*;
import com.example.quanlyhocphan.Service.ServiceImp.AccountDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

public class CommonController {
    @Autowired
    public PasswordEncoder passwordEncoder;
    ModelAndView mv = new ModelAndView();
    @Autowired
    KhoaService khoaService;

    @Autowired
    HocPhanService hocPhanService;
    @Autowired
    AccountDetailService accountDetailService;

    @Autowired
    LopHocPhanService lopHocPhanService;

    @Autowired
    NamHocHocKyService namHocHocKyService;

    @Autowired
    DangKyLopHocPhanService dangKyLopHocPhanService;

    @Autowired
    DiemThiService diemThiService;

    @Autowired
    ChuyenNganhService chuyenNganhService;
    @Autowired
    CTDTService ctdtService;

    @Autowired
    HocPhanCTDTService hocPhanCTDTService;
}
