package com.example.quanlyhocphan.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DiemThi {
    private SinhVien sinhVien;
    private NamHocHocKy namHocHocKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayThi;
    private int lanHoc;
    private Double diem;
    private HocPhan hocPhan;
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

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public int getLanHoc() {
        return lanHoc;
    }

    public void setLanHoc(int lanHoc) {
        this.lanHoc = lanHoc;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public LopHocPhan getLopHocPhan() {
        return lopHocPhan;
    }

    public void setLopHocPhan(LopHocPhan lopHocPhan) {
        this.lopHocPhan = lopHocPhan;
    }
}
