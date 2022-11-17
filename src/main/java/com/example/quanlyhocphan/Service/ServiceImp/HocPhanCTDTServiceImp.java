package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.HocPhanCTDTDao;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import com.example.quanlyhocphan.Service.HocPhanCTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HocPhanCTDTServiceImp implements HocPhanCTDTService {
    @Autowired
    HocPhanCTDTDao hocPhanCTDTDao;

    @Override
    public int InsertHocPhanCTDT(HocPhanCTDT hocPhanCTDT) {
        return hocPhanCTDTDao.insertHocPhanCTDT(hocPhanCTDT);
    }
}
