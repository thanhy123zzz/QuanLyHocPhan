package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;

import java.util.List;

public interface DangKyLopHocPhanService {
    List<DangKyLopHocPhan> listSinhVienofLop(int Malop);

    int getqldk(int malop);
    int insert(DangKyLopHocPhan dangKyLopHocPhan);
    Boolean checkSVDKHP(String masv, String malop);
}
