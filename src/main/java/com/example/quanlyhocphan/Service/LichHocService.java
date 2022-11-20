package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.LichHoc;

import java.util.List;

public interface LichHocService {
    List<LichHoc> getListLicHoc();
    LichHoc getLichHoc(String maLichHoc);
    List<LichHoc> getLisLichHocs(String masv);
}
