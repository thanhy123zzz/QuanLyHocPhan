package com.example.quanlyhocphan.Entities;

public class CTDT {
    private String MaCTDT;
    private ChuyenNganh chuyenNganh;
    private NamHocHocKy namHocHocKy;
    private int nienkhoa;

    public CTDT(String maCTDT) {
        MaCTDT = maCTDT;
    }

    public CTDT() {
    }

    public CTDT(String maCTDT, int nienkhoa) {
        MaCTDT = maCTDT;
        this.nienkhoa = nienkhoa;
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

    public CTDT(String MaCTDT, ChuyenNganh chuyenNganh, NamHocHocKy namHocHocKy, int nienkhoa) {
        this.MaCTDT = MaCTDT;
        this.chuyenNganh = chuyenNganh;
        this.namHocHocKy = namHocHocKy;
        this.nienkhoa = nienkhoa;
    }

    public NamHocHocKy getNamHocHocKy() {
        return namHocHocKy;
    }

    public void setNamHocHocKy(NamHocHocKy namHocHocKy) {
        this.namHocHocKy = namHocHocKy;
    }

    public int getNienkhoa() {
        return this.nienkhoa;
    }

    public void setNienkhoa(int nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

}
