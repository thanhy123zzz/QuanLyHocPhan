package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.HocPhan;

import java.util.List;

public interface HocPhanDao {
    List<HocPhan> getListHocPhan(String MaKhoa);
    String insertHocPhan(HocPhan hp);

    HocPhan getHocPhan(int MaHP);

    String updateHocPhan(HocPhan HP);

    List<HocPhan> getListByMaSV(String masv);
}
