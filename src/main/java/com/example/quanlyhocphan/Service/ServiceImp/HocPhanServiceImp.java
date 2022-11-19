package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.HocPhanDao;
import com.example.quanlyhocphan.Dao.KhoaDao;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HocPhanServiceImp implements HocPhanService {
    @Autowired
    HocPhanDao hocPhanDao;
    @Autowired
    KhoaDao khoaDao;
    @Override
    public List<HocPhan> getListHocPhan(String MaKhoa) {
        List<HocPhan> listHP = hocPhanDao.getListHocPhan(MaKhoa);
        for (HocPhan hp : listHP) {
            hp.setKhoa(khoaDao.getKhoa(hp.getKhoa().getMaKhoa()));
        }
        return listHP;
    }

    @Override
    public String insertHocPhan(HocPhan hp) {
        return hocPhanDao.insertHocPhan(hp);
    }

    @Override
    public HocPhan getHocPhan(int MaHP) {
        return hocPhanDao.getHocPhan(MaHP);
    }

    @Override
    public String updateHocPhan(HocPhan hp) {
        return hocPhanDao.updateHocPhan(hp);
    }

    @Override
    public List<HocPhan> getListByMaSV(String masv){
        List<HocPhan> list = hocPhanDao.getListByMaSV(masv);
        for(HocPhan hp : list){
            hp.setKhoa(khoaDao.getKhoa(hp.getKhoa().getMaKhoa()));
        }
        return list;
    }
}
