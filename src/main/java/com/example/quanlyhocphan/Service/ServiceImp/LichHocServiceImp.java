package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.CaHocDao;
import com.example.quanlyhocphan.Dao.LichHocDao;
import com.example.quanlyhocphan.Entities.LichHoc;
import com.example.quanlyhocphan.Service.LichHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LichHocServiceImp implements LichHocService {
    @Autowired
    LichHocDao lichHocDao;
    @Autowired
    CaHocDao caHocDao;
    @Override
    public List<LichHoc> getListLicHoc() {
        List<LichHoc> lis = lichHocDao.getlistLichHoc();
        for(LichHoc l : lis){
            l.setCaHoc(caHocDao.getCaHoc(l.getCaHoc().getMaCaHoc()));
        }
        return lis;
    }

    @Override
    public LichHoc getLichHoc(String maLichHoc) {
        LichHoc l = lichHocDao.getLichHoc(maLichHoc);
        l.setCaHoc(caHocDao.getCaHoc(l.getCaHoc().getMaCaHoc()));
        return l;
    }
}
