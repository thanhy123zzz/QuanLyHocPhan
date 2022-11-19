package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.CTDTDao;
import com.example.quanlyhocphan.Dao.ChuyenNganhDao;
import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import com.example.quanlyhocphan.Service.CTDTService;
import com.example.quanlyhocphan.Service.NamHocHocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTDTServiceImp implements CTDTService {
    @Autowired
    CTDTDao ctdtDao;
    @Autowired
    ChuyenNganhDao chuyenNganhDao;
    @Autowired
    NamHocHocKyDao namHocHocKyDao;
    @Override
    public CTDT getCTDT(String maCTDT) {
        CTDT ctdt =  ctdtDao.getCTDT(maCTDT);
        ctdt.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(ctdt.getNamHocHocKy().getDotHoc()));
        ctdt.setChuyenNganh(chuyenNganhDao.getChuyenNganh(ctdt.getChuyenNganh().getMaChuyenNganh()));
        return ctdt;
    }

    @Override
    public String insertCTDT(CTDT ctdt, String DotHoc) {
        return ctdtDao.insertCTDT(ctdt, DotHoc);
    }

    @Override
    public List<CTDT> getListCTDT() {
        List<CTDT> list = ctdtDao.getListCTDT();
        for(CTDT c : list){
            c.setChuyenNganh(chuyenNganhDao.getChuyenNganh(c.getChuyenNganh().getMaChuyenNganh()));
            c.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(c.getNamHocHocKy().getDotHoc()));
        }
        return list;
    }

    @Override
    public List<CTDT> getListbyMaSV(String masv){
        List<CTDT> list = ctdtDao.getbyMaSV(masv);
        for(CTDT ct: list){
            ct.setChuyenNganh(chuyenNganhDao.getChuyenNganh(ct.getChuyenNganh().getMaChuyenNganh()));
            ct.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(ct.getNamHocHocKy().getDotHoc()));
        }
        return list;
    }
}
