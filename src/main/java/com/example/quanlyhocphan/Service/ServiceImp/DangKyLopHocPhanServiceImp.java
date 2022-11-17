package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.DangKyLopHocPhanDao;
import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Dao.SinhVienDao;
import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.SinhVien;
import com.example.quanlyhocphan.Service.DangKyLopHocPhanService;
import com.example.quanlyhocphan.Service.NamHocHocKyService;
import com.example.quanlyhocphan.Service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DangKyLopHocPhanServiceImp implements DangKyLopHocPhanService {
    @Autowired
    DangKyLopHocPhanDao dangKyLopHocPhanDao;
    @Autowired
    SinhVienDao sinhVienDao;
    @Autowired
    NamHocHocKyDao namHocHocKyDao;
    @Autowired
    LopHocPhanDao lopHocPhanDao;
    @Override
    public List<DangKyLopHocPhan> listSinhVienofLop(int Malop) {
        List<DangKyLopHocPhan> list  = dangKyLopHocPhanDao.getListSVformLopHocPhan(Malop);
        for(DangKyLopHocPhan dk : list){
            dk.setSinhVien(sinhVienDao.getSV(dk.getSinhVien().getMaSV()));
            dk.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(dk.getNamHocHocKy().getDotHoc()));
        }
        return list;
    }
}
