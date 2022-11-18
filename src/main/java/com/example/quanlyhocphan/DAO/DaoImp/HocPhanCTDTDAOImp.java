package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.HocPhanCTDTDao;
import com.example.quanlyhocphan.Entities.HocPhanCTDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HocPhanCTDTDAOImp implements HocPhanCTDTDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertHocPhanCTDT(HocPhanCTDT hocPhanCTDT) {
        String sql = "insert into HocPhanCTDT values(?,?)";
        return jdbcTemplate.update(sql,new Object[]{hocPhanCTDT.getCtdt().getMaCTDT(),hocPhanCTDT.getHocPhan().getMaHocPhan()});
    }
}
