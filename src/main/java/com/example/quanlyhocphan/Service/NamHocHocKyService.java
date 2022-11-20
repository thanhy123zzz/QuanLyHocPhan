package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.NamHocHocKy;

import java.util.Date;
import java.util.List;

public interface NamHocHocKyService {
    NamHocHocKy getNamHocHocKy(Date dotHoc);

    List<NamHocHocKy> getLisNamHoc();

    List<NamHocHocKy> getListByMaSVCN(String masv);
}
