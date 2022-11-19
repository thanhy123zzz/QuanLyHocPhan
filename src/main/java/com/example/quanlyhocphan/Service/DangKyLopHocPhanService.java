package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;

import java.util.List;

public interface DangKyLopHocPhanService {
    List<DangKyLopHocPhan> listSinhVienofLop(int Malop);

    int getqldk(int malop);
}
