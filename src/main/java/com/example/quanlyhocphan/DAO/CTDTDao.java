package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.CTDT;

import java.util.List;

public interface CTDTDao {
    CTDT getCTDT(String MaCTDT);
    String insertCTDT(CTDT ctdt, String dothoc);

    List<CTDT> getListCTDT();
}
