package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.*;
import com.example.quanlyhocphan.Entities.LichHoc;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.PhongHoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class LopHocPhanService implements com.example.quanlyhocphan.Service.LopHocPhanService {
    @Autowired
    LopHocPhanDao lopHocPhanDao;
    @Autowired
    NamHocHocKyDao namHocHocKyDao;
    @Autowired
    LichHocDao lichHocDao;
    @Autowired
    GiaoVienDao giaoVienDaol;
    @Autowired
    PhongHocDao phongHocDao;
    @Autowired
    HocPhanDao hocPhanDao;
    @Override
    public List<LopHocPhan> getListLopHocPhan(String dotHoc) {
        List<LopHocPhan> listLopHocPhan = lopHocPhanDao.getListLopHocPhan(dotHoc);
        for (LopHocPhan lopHocPhan : listLopHocPhan){
            lopHocPhan.setDocHoc(namHocHocKyDao.getNamHocHocKy(lopHocPhan.getDocHoc().getDotHoc()));
            lopHocPhan.setLichHoc(lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc()));
            lopHocPhan.setGiaoVien(giaoVienDaol.getGiaoVien(lopHocPhan.getGiaoVien().getMaGV()));
            lopHocPhan.setPhongHoc(phongHocDao.getPhongHoc(lopHocPhan.getPhongHoc().getMaPhong()));
            lopHocPhan.setHocPhan(hocPhanDao.getHocPhan(lopHocPhan.getHocPhan().getMaHocPhan()));
        }

        return listLopHocPhan;
    }
}
