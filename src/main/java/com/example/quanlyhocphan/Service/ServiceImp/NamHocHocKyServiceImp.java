package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import com.example.quanlyhocphan.Service.NamHocHocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NamHocHocKyServiceImp implements NamHocHocKyService {
    @Autowired
    NamHocHocKyDao namHocHocKyDao;
    @Override
    public NamHocHocKy getNamHocHocKy(Date dotHoc) {
        return namHocHocKyDao.getNamHocHocKy(dotHoc);
    }

    @Override
    public List<NamHocHocKy> getLisNamHoc() {
        return namHocHocKyDao.getListNamHoc();
    }
}
