package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.PhongHoc;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhongHocMapper implements RowMapper<PhongHoc> {

    @Override
    public PhongHoc mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhongHoc ph = new PhongHoc();
        ph.setMaPhong(rs.getString("MaPhong"));
        ph.setTenPhong(rs.getString("TenPhong"));
        ph.setSoGhe(rs.getInt("SoGhe"));
        return ph;
    }
}
