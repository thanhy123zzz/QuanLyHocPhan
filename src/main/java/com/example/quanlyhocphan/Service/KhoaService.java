package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.Khoa;

import java.util.List;

public interface KhoaService {
    List<Khoa> getListKhoa();

    Khoa getKhoa(String MaKhoa);
}
