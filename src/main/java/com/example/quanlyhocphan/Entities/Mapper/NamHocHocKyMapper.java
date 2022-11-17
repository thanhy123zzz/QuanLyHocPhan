package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.NamHocHocKy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NamHocHocKyMapper implements RowMapper<NamHocHocKy> {
    @Override
    public NamHocHocKy mapRow(ResultSet rs, int rowNum) throws SQLException {
        NamHocHocKy namHocHocKy = new NamHocHocKy();
        namHocHocKy.setDotHoc(rs.getDate("DotHoc"));
        namHocHocKy.setHocKi(rs.getInt("HocKy"));
        namHocHocKy.setNamHoc(rs.getString("NamHoc"));
        return namHocHocKy;
    }
}
