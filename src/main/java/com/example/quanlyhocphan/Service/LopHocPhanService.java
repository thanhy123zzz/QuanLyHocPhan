package com.example.quanlyhocphan.Service;

import com.example.quanlyhocphan.Entities.LopHocPhan;

import java.util.Date;
import java.util.List;

public interface LopHocPhanService {
    List<LopHocPhan> getListLopHocPhan(String dotHoc);
}
