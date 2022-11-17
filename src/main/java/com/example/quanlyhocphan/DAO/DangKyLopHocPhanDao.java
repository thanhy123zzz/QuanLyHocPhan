package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.SinhVien;

import java.util.List;

public interface DangKyLopHocPhanDao {
    List<DangKyLopHocPhan> getListSVformLopHocPhan(int MaLop);
}
