package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;

import java.util.List;

public interface DangKyLopHocPhanDao {
    List<DangKyLopHocPhan> getListSVformLopHocPhan(int MaLop);

    int insert(DangKyLopHocPhan dangKyLopHocPhan);

    Boolean checkSVDKHP(String masv, String malop);
}
