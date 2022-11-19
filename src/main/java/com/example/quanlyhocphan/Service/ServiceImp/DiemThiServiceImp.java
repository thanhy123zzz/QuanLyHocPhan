package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.DiemThiDao;
import com.example.quanlyhocphan.Dao.HocPhanDao;
import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Dao.SinhVienDao;
import com.example.quanlyhocphan.Entities.DiemThi;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.SinhVien;
import com.example.quanlyhocphan.Service.DiemThiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiemThiServiceImp implements DiemThiService {
    @Autowired
    LopHocPhanDao lopHocPhanDao;
    @Autowired
    DiemThiDao diemThiDao;
    @Autowired
    SinhVienDao sinhVienDao;
    @Autowired
    NamHocHocKyDao namHocHocKyDao;
    @Autowired
    HocPhanDao hocPhanDao;

    @Override
    public String insertDiem(int malop, String mssv, double diem) {
        LopHocPhan lh = lopHocPhanDao.getLopHocPhan(malop);
        DiemThi diemThi = new DiemThi();
        diemThi.setDiem(diem);
        diemThi.setLopHocPhan(lh);
        diemThi.setHocPhan(lh.getHocPhan());
        diemThi.setNamHocHocKy(lh.getDocHoc());
        diemThi.setSinhVien(new SinhVien(mssv));
        return diemThiDao.updateDiemThi(diemThi);
    }

    @Override
    public List<DiemThi> getListDiemThi(int malop) {
        List<DiemThi> list  = diemThiDao.getListDiemThi(malop);
        for(DiemThi d : list){
            d.setSinhVien(sinhVienDao.getSV(d.getSinhVien().getMaSV()));
            d.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(d.getNamHocHocKy().getDotHoc()));
        }
        return list;
    }

    @Override
    public List<DiemThi> getDiemThiByMaSV(String masv){
        List<DiemThi> list  = diemThiDao.getDiemThiByMaSV(masv);
        for(DiemThi d : list){
            d.setSinhVien(sinhVienDao.getSV(d.getSinhVien().getMaSV()));
            d.setNamHocHocKy(namHocHocKyDao.getNamHocHocKy(d.getNamHocHocKy().getDotHoc()));
            d.setHocPhan(hocPhanDao.getHocPhan(d.getHocPhan().getMaHocPhan()));
            d.setLopHocPhan(lopHocPhanDao.getLopHocPhan(d.getLopHocPhan().getMaLop()));
        }
        return list;
    }
}
