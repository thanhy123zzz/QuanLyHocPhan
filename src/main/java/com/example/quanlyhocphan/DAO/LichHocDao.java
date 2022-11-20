package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.LichHoc;

import java.util.List;

public interface LichHocDao {
    LichHoc getLichHoc(String maLichHoc);

    List<LichHoc> getlistLichHoc();

    List<LichHoc> getLisLichHocs(String masv);
}
