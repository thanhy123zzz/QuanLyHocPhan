package com.example.quanlyhocphan.Entities;

public class CTDT {
    private String MaCTDT;
    private ChuyenNganh chuyenNganh;
    private NamHocHocKy namHocHocKy;

    public CTDT(String maCTDT) {
        MaCTDT = maCTDT;
    }
    public CTDT() {
    }
    public String getMaCTDT() {
        return MaCTDT;
    }

    public void setMaCTDT(String maCTDT) {
        MaCTDT = maCTDT;
    }

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public NamHocHocKy getNamHocHocKy() {
        return namHocHocKy;
    }

    public void setNamHocHocKy(NamHocHocKy namHocHocKy) {
        this.namHocHocKy = namHocHocKy;
    }
}
