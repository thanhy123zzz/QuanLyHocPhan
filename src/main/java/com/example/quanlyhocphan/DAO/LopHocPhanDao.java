package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import com.example.quanlyhocphan.Entities.LopHocPhan;

import java.util.List;

public interface LopHocPhanDao {
    List<LopHocPhan> getListLopHocPhan(String dotHoc);

    LopHocPhan getLopHocPhan(int MaLop);
    String insertLopHocPhan(LopHocPhan lopHocPhan, String dotHoc);

    int doiMaxSV(int malop, int sl);

    String doiTrangThai(int maLop, boolean trangThai);
}
