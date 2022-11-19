package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.PhongHoc;

import java.util.List;

public interface PhongHocDao {
    PhongHoc getPhongHoc(String maPhong);

    List<PhongHoc> getListPhongHoc();
}
