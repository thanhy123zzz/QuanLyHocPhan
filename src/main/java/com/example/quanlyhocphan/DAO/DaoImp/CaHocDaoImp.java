package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.CaHocDao;
import com.example.quanlyhocphan.Entities.CaHoc;
import com.example.quanlyhocphan.Entities.Mapper.CaHocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CaHocDaoImp implements CaHocDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public CaHoc getCaHoc(String ma) {
        String sql = "select*from CaHoc where MaCaHoc = '"+ma+"'";
        return jdbcTemplate.query(sql,new CaHocMapper()).get(0);
    }
}
