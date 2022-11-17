package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.SinhVienDao;
import com.example.quanlyhocphan.Entities.SinhVien;
import com.example.quanlyhocphan.Service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinhVienServiceImp implements SinhVienService {
    @Autowired
    SinhVienDao sinhVienDao;
    @Override
    public SinhVien getSinhVien(String MaSV) {
        return sinhVienDao.getSV(MaSV);
    }
}
