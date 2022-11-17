package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.CaHoc;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaHocMapper implements RowMapper<CaHoc> {
    @Override
    public CaHoc mapRow(ResultSet rs, int rowNum) throws SQLException {
        CaHoc caHoc = new CaHoc();
        caHoc.setMaCaHoc(rs.getString("MaCaHoc"));
        caHoc.setCaHoc(rs.getString("CaHoc"));
        caHoc.setGioBatDau(rs.getString("GioBatDau"));
        caHoc.setGioBatDau(rs.getString("GioKetThuc"));
        return caHoc;
    }
}
