package com.example.quanlyhocphan.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DangKyLopHocPhan {
    private SinhVien sinhVien;
    private NamHocHocKy namHocHocKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDangKy;
    private LopHocPhan lopHocPhan;

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public NamHocHocKy getNamHocHocKy() {
        return namHocHocKy;
    }

    public void setNamHocHocKy(NamHocHocKy namHocHocKy) {
        this.namHocHocKy = namHocHocKy;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }
}
