package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiemThiMapper implements RowMapper<DiemThi> {
    @Override
    public DiemThi mapRow(ResultSet rs, int rowNum) throws SQLException {
        DiemThi diemThi = new DiemThi();
        diemThi.setDiem(rs.getDouble("Diem"));
        diemThi.setNgayThi(rs.getDate("NgayThi"));
        diemThi.setHocPhan(new HocPhan(rs.getInt("MaHP")));
        diemThi.setLopHocPhan(new LopHocPhan(rs.getInt("MaLop")));
        diemThi.setSinhVien(new SinhVien(rs.getString("MaSV")));
        diemThi.setNamHocHocKy(new NamHocHocKy(rs.getDate("DotHoc")));
        diemThi.setLanHoc(rs.getInt("LanHoc"));
        return diemThi;
    }
}
