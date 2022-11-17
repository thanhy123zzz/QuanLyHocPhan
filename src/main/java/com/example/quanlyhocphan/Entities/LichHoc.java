package com.example.quanlyhocphan.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LichHoc {
    private String maLichHoc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;
    private NamHocHocKy namHocHocKy;
    private CaHoc caHoc;

    public LichHoc(String maLichHoc) {
        this.maLichHoc = maLichHoc;
    }

    public LichHoc() {
    }

    public String getMaLichHoc() {
        return maLichHoc;
    }

    public void setMaLichHoc(String maLichHoc) {
        this.maLichHoc = maLichHoc;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public NamHocHocKy getNamHocHocKy() {
        return namHocHocKy;
    }

    public void setNamHocHocKy(NamHocHocKy namHocHocKy) {
        this.namHocHocKy = namHocHocKy;
    }

    public CaHoc getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(CaHoc caHoc) {
        this.caHoc = caHoc;
    }
}
