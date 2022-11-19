package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.ChuyenNganhDao;
import com.example.quanlyhocphan.Dao.KhoaDao;
import com.example.quanlyhocphan.Entities.ChuyenNganh;
import com.example.quanlyhocphan.Service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenNganhServiceImp implements ChuyenNganhService {
    @Autowired
    ChuyenNganhDao chuyenNganhDao;

    @Autowired
    KhoaDao khoaDao;

    @Override
    public ChuyenNganh getChuyenNganh(String maCN) {
        return chuyenNganhDao.getChuyenNganh(maCN);
    }

    @Override
    public List<ChuyenNganh> getListCN() {
        return chuyenNganhDao.getListChuyenNganh();
    }

    @Override
    public ChuyenNganh getCNByMaSV(String masv){
        ChuyenNganh cn = chuyenNganhDao.getListByMaSV(masv).get(0);
        cn.setKhoa(khoaDao.getKhoa(cn.getKhoa().getMaKhoa()));
        return cn;
    }
}
