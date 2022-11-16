package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.Khoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HocPhanMapper implements RowMapper<HocPhan> {

    @Override
    public HocPhan mapRow(ResultSet rs, int rowNum) throws SQLException {
        HocPhan hp = new HocPhan();
        hp.setMaHocPhan(rs.getInt("MaHP"));
        hp.setTenHocPhan(rs.getString("TenHocPhan"));
        hp.setSoTinChi(rs.getInt("SoTinChi"));
        hp.setKhoa(new Khoa(rs.getString("MaKhoa")));
        return hp;
    }
}
