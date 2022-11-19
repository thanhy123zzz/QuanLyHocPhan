package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.ChuyenNganh;

import java.util.List;

public interface ChuyenNganhDao {
    ChuyenNganh getChuyenNganh(String MaCn);

    List<ChuyenNganh> getListChuyenNganh();

    List<ChuyenNganh> getListByMaSV(String masv);
}
