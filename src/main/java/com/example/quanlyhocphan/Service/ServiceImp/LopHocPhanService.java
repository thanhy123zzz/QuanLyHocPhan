package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.*;
import com.example.quanlyhocphan.Entities.LichHoc;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    CaHocDao cahocdao;

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

    @Override
    public LopHocPhan getLopHocPhan(int MaLop) {
        LopHocPhan lhp = lopHocPhanDao.getLopHocPhan(MaLop);
        lhp.setDocHoc(namHocHocKyDao.getNamHocHocKy(lhp.getDocHoc().getDotHoc()));
        lhp.setLichHoc(lichHocDao.getLichHoc(lhp.getLichHoc().getMaLichHoc()));
        lhp.setGiaoVien(giaoVienDaol.getGiaoVien(lhp.getGiaoVien().getMaGV()));
        lhp.setPhongHoc(phongHocDao.getPhongHoc(lhp.getPhongHoc().getMaPhong()));
        lhp.setHocPhan(hocPhanDao.getHocPhan(lhp.getHocPhan().getMaHocPhan()));
        return lhp;
    }

    @Override
    public String insertLopHocPhan(LopHocPhan lopHocPhan, String dotHoc) {
        return lopHocPhanDao.insertLopHocPhan(lopHocPhan,dotHoc);
    }

    @Override
    public List<LopHocPhan> getListByMaSVandMaCN(String masv){
        List<LopHocPhan> listLopHocPhan = lopHocPhanDao.getListByMaSVandMaCN(masv);
        for (LopHocPhan lopHocPhan : listLopHocPhan){
            lopHocPhan.setDocHoc(namHocHocKyDao.getNamHocHocKy(lopHocPhan.getDocHoc().getDotHoc()));
            lopHocPhan.setLichHoc(lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc()));
            lopHocPhan.setGiaoVien(giaoVienDaol.getGiaoVien(lopHocPhan.getGiaoVien().getMaGV()));
            lopHocPhan.setPhongHoc(phongHocDao.getPhongHoc(lopHocPhan.getPhongHoc().getMaPhong()));
            lopHocPhan.setHocPhan(hocPhanDao.getHocPhan(lopHocPhan.getHocPhan().getMaHocPhan()));
        }
        return listLopHocPhan;
    }

    @Override
    public List<LopHocPhan> getListLopHocPhansByMaSV(String masv){
        List<LopHocPhan> list = lopHocPhanDao.getListLopHocPhansByMaSV(masv);
        for (LopHocPhan lopHocPhan : list){
            lopHocPhan.setDocHoc(namHocHocKyDao.getNamHocHocKy(lopHocPhan.getDocHoc().getDotHoc()));
            lopHocPhan.setLichHoc(lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc()));
            lopHocPhan.setGiaoVien(giaoVienDaol.getGiaoVien(lopHocPhan.getGiaoVien().getMaGV()));
            lopHocPhan.setPhongHoc(phongHocDao.getPhongHoc(lopHocPhan.getPhongHoc().getMaPhong()));
            lopHocPhan.setHocPhan(hocPhanDao.getHocPhan(lopHocPhan.getHocPhan().getMaHocPhan()));
            LichHoc lh = lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc());
            lh.setCaHoc(cahocdao.getCaHocByMaLopMaHP(lopHocPhan.getMaLop(), lopHocPhan.getHocPhan().getMaHocPhan()));
            lopHocPhan.setLichHoc(lh);
        }
        return list;
    }

    @Override
    public List<LopHocPhan> getListLopHocPhanByDotHoc(String dotHoc,String masv){
        List<LopHocPhan> list = lopHocPhanDao.getListLopHocPhanByDotHoc(dotHoc,masv);
        for (LopHocPhan lopHocPhan : list){
            lopHocPhan.setDocHoc(namHocHocKyDao.getNamHocHocKy(lopHocPhan.getDocHoc().getDotHoc()));
            lopHocPhan.setLichHoc(lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc()));
            lopHocPhan.setGiaoVien(giaoVienDaol.getGiaoVien(lopHocPhan.getGiaoVien().getMaGV()));
            lopHocPhan.setPhongHoc(phongHocDao.getPhongHoc(lopHocPhan.getPhongHoc().getMaPhong()));
            lopHocPhan.setHocPhan(hocPhanDao.getHocPhan(lopHocPhan.getHocPhan().getMaHocPhan()));
            LichHoc lh = lichHocDao.getLichHoc(lopHocPhan.getLichHoc().getMaLichHoc());
            lh.setCaHoc(cahocdao.getCaHocByMaLopMaHP(lopHocPhan.getMaLop(), lopHocPhan.getHocPhan().getMaHocPhan()));
            lopHocPhan.setLichHoc(lh);
        }
        return list;
    }
}
