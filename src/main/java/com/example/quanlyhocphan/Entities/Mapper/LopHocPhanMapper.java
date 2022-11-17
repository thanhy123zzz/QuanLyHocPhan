package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LopHocPhanMapper implements RowMapper<LopHocPhan> {

    @Override
    public LopHocPhan mapRow(ResultSet rs, int rowNum) throws SQLException {
        LopHocPhan lopHocPhan = new LopHocPhan();
        lopHocPhan.setMaLop(rs.getInt("MaLop"));
        lopHocPhan.setTenLop(rs.getString("TenLop"));
        lopHocPhan.setMaxSV(rs.getInt("MaxSV"));
        lopHocPhan.setDocHoc(new NamHocHocKy(rs.getDate("DotHoc")));
        lopHocPhan.setLichHoc(new LichHoc(rs.getString("MaLichHoc")));
        lopHocPhan.setGiaoVien(new GiaoVien(rs.getString("MaGiaoVien")));
        lopHocPhan.setPhongHoc(new PhongHoc(rs.getString("MaPhong")));
        lopHocPhan.setHocPhan(new HocPhan(rs.getInt("MaHP")));
        return lopHocPhan;
    }
}
