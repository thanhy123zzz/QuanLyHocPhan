package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.GiaoVien;

import java.util.List;

public interface GiaoVienDao {
    GiaoVien getGiaoVien(String maGV);

    List<GiaoVien> getListGiaoVien();
}
