package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.DiemThi;

import java.util.List;

public interface DiemThiService {
    String insertDiem(int malop, String mssv, double diem);

    List<DiemThi> getListDiemThi(int malop);
}