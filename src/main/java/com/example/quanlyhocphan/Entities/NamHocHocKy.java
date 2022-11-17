package com.example.quanlyhocphan.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NamHocHocKy {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dotHoc;
    private int hocKi;
    private String namHoc;

    public Date getDotHoc() {
        return dotHoc;
    }

    public void setDotHoc(Date dotHoc) {
        this.dotHoc = dotHoc;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public NamHocHocKy() {
    }
    public NamHocHocKy(Date dotHoc) {
        this.dotHoc = dotHoc;
    }
}
