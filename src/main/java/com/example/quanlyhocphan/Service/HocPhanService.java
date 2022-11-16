package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.HocPhan;

import java.util.List;

public interface HocPhanService {
    List<HocPhan> getListHocPhan(String MaKhoa);

    String insertHocPhan(HocPhan hp);

    HocPhan getHocPhan(int MaHP);

    String updateHocPhan(HocPhan hp);
}
