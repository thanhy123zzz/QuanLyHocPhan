package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.ChuyenNganh;
import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CTDTMapper implements RowMapper<CTDT> {
    @Override
    public CTDT mapRow(ResultSet rs, int rowNum) throws SQLException {
        CTDT ctdt = new CTDT();
        ctdt.setMaCTDT(rs.getString("MaCTDT"));
        ctdt.setChuyenNganh(new ChuyenNganh(rs.getString("MaChuyenNganh")));
        ctdt.setNamHocHocKy(new NamHocHocKy(rs.getDate("DotHoc")));
        return ctdt;
    }
}
