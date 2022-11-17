package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.DiemThi;

import java.util.List;

public interface DiemThiDao {
    DiemThi getDiemThi(String mssv, int maLop);

    List<DiemThi> getListDiemThi(int maLop);

    String insertDiemThi(DiemThi diemThi);

    String updateDiemThi(DiemThi diemThi);
}
