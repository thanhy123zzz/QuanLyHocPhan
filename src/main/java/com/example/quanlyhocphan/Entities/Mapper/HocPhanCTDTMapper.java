package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HocPhanCTDTMapper implements RowMapper<HocPhanCTDT> {
    @Override
    public HocPhanCTDT mapRow(ResultSet rs, int rowNum) throws SQLException {
        HocPhanCTDT hocPhanCTDT = new HocPhanCTDT();
        hocPhanCTDT.setCtdt(new CTDT(rs.getString("MaCTDT")));
        hocPhanCTDT.setHocPhan(new HocPhan(rs.getInt("MaHP")));
        return hocPhanCTDT;
    }
}
