package com.example.quanlyhocphan.Entities;

public class LopHocPhan {
    private int maLop;
    private String tenLop;
    private int maxSV;
    private NamHocHocKy docHoc;
    private LichHoc lichHoc;
    private GiaoVien giaoVien;
    private PhongHoc phongHoc;
    private HocPhan hocPhan;

    private boolean trangThai;

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public LopHocPhan(int maLop) {
        this.maLop = maLop;
    }
    public LopHocPhan() {
    }
    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getMaxSV() {
        return maxSV;
    }

    public void setMaxSV(int maxSV) {
        this.maxSV = maxSV;
    }

    public NamHocHocKy getDocHoc() {
        return docHoc;
    }

    public void setDocHoc(NamHocHocKy docHoc) {
        this.docHoc = docHoc;
    }

    public LichHoc getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(LichHoc lichHoc) {
        this.lichHoc = lichHoc;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public PhongHoc getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(PhongHoc phongHoc) {
        this.phongHoc = phongHoc;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }
}
