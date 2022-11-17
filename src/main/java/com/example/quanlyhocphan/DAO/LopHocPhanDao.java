package com.example.quanlyhocphan.Dao;

import com.example.quanlyhocphan.Entities.*;

import java.util.Date;
import java.util.List;

public interface LopHocPhanDao {
    List<LopHocPhan> getListLopHocPhan(String dotHoc);

}
