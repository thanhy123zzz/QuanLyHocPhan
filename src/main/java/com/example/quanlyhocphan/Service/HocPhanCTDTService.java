package com.example.quanlyhocphan.Service;

import java.util.List;

import com.example.quanlyhocphan.Entities.HocPhanCTDT;

public interface HocPhanCTDTService {
    int InsertHocPhanCTDT(HocPhanCTDT hocPhanCTDT);

    List<HocPhanCTDT> getListByMaSV(String masv);

    List<HocPhanCTDT> getListByMaCTDT(String maCTDT);


}
