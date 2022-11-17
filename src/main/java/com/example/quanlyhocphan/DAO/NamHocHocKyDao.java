package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.NamHocHocKy;

import java.util.Date;
import java.util.List;

public interface NamHocHocKyDao {
    NamHocHocKy getNamHocHocKy(Date dotHoc);

    List<NamHocHocKy> getListNamHoc();
}
