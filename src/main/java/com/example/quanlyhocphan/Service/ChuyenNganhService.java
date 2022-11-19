package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.ChuyenNganh;

import java.util.List;

public interface ChuyenNganhService {
    ChuyenNganh getChuyenNganh(String maCN);

    List<ChuyenNganh> getListCN();

    ChuyenNganh getCNByMaSV(String masv);
}
