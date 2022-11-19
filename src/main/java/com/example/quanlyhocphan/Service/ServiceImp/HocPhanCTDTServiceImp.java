package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.CTDTDao;
import com.example.quanlyhocphan.Dao.HocPhanCTDTDao;
import com.example.quanlyhocphan.Dao.HocPhanDao;
import com.example.quanlyhocphan.Dao.KhoaDao;
import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import com.example.quanlyhocphan.Entities.Khoa;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import com.example.quanlyhocphan.Service.HocPhanCTDTService;

import java.util.List;

import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HocPhanCTDTServiceImp implements HocPhanCTDTService {
    @Autowired
    HocPhanCTDTDao hocPhanCTDTDao;

    @Autowired
    CTDTDao ctdtDao;
    @Autowired
    HocPhanDao hocPhanDao;

    @Autowired
    NamHocHocKyDao namHocHocKyDao;

    @Autowired 
    KhoaDao khoaDao;

    @Override
    public int InsertHocPhanCTDT(HocPhanCTDT hocPhanCTDT) {
        return hocPhanCTDTDao.insertHocPhanCTDT(hocPhanCTDT);
    }

    @Override
    public List<HocPhanCTDT> getListByMaSV(String masv){
        List<HocPhanCTDT> list = hocPhanCTDTDao.getListByMaSV(masv);
        for(HocPhanCTDT hp : list){
            hp.setCtdt(ctdtDao.getCTDT(hp.getCtdt().getMaCTDT()));
            CTDT ct =  hp.getCtdt();
            ct.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(hp.getCtdt().getNamHocHocKy().getDotHoc()));
            hp.setCtdt(ct);
            //
            hp.setHocPhan(hocPhanDao.getHocPhan(hp.getHocPhan().getMaHocPhan()));
            HocPhan hp1 = hp.getHocPhan();
            Khoa khoa = khoaDao.getKhoa(hp.getHocPhan().getKhoa().getMaKhoa());
            hp1.setKhoa(khoa);
        }
        return list;
    }

    @Override
    public List<HocPhanCTDT> getListByMaCTDT(String maCTDT) {
        List<HocPhanCTDT> list = hocPhanCTDTDao.getListHPCTDT(maCTDT);
        for(HocPhanCTDT h : list){
            CTDT ctdt = ctdtDao.getCTDT(maCTDT);
            ctdt.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(ctdt.getNamHocHocKy().getDotHoc()));
            h.setCtdt(ctdt);

            HocPhan hp = hocPhanDao.getHocPhan(h.getHocPhan().getMaHocPhan());
            hp.setKhoa(khoaDao.getKhoa(hp.getKhoa().getMaKhoa()));
            h.setHocPhan(hp);
        }
        return list;
    }
}
