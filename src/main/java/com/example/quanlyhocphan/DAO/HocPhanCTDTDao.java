package com.example.quanlyhocphan.Dao;

import java.util.List;

import com.example.quanlyhocphan.Entities.HocPhanCTDT;

public interface HocPhanCTDTDao {
    int insertHocPhanCTDT(HocPhanCTDT hocPhanCTDT);

    List<HocPhanCTDT> getListByMaSV(String masv);
}
