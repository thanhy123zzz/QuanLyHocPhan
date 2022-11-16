package com.example.quanlyhocphan.Controllers;

import com.example.quanlyhocphan.Dao.HocPhanDao;
import com.example.quanlyhocphan.Service.HocPhanService;
import com.example.quanlyhocphan.Service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class CommonController {
    ModelAndView mv = new ModelAndView();
    @Autowired
    KhoaService khoaService;

    @Autowired
    HocPhanService hocPhanService;
}
