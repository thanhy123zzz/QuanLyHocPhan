package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.CTDT;

import java.util.List;

public interface CTDTService {
    CTDT getCTDT(String maCTDT);
    String insertCTDT(CTDT ctdt,String DotHoc);

    List<CTDT> getListCTDT();

    List<CTDT> getListbyMaSV(String masv);
}
