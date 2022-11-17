package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.LopHocPhan;

import java.util.List;

public interface LopHocPhanDao {
    List<LopHocPhan> getListLopHocPhan(String dotHoc);

    LopHocPhan getLopHocPhan(int MaLop);
}
