package com.example.quanlyhocphan.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class LichHoc {
    private String maLichHoc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;
    private String thu;
    private CaHoc caHoc;
    private NamHocHocKy namHocHocKy;
    private List<LopHocPhan> lopHocPhans;

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

    public String getThu() {
        return this.thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
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

    public CaHoc getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(CaHoc caHoc) {
        this.caHoc = caHoc;
    }


    public List<LopHocPhan> getLopHocPhans() {
        return this.lopHocPhans;
    }

    public void setLopHocPhans(List<LopHocPhan> lopHocPhans) {
        this.lopHocPhans = lopHocPhans;
    }
    

    public NamHocHocKy getNamHocHocKy() {
        return this.namHocHocKy;
    }

    public void setNamHocHocKy(NamHocHocKy namHocHocKy) {
        this.namHocHocKy = namHocHocKy;
    }

}
