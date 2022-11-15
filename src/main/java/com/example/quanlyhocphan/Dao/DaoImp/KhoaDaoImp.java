package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.KhoaDao;
import com.example.quanlyhocphan.Entities.Khoa;
import com.example.quanlyhocphan.Entities.Mapper.KhoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KhoaDaoImp implements KhoaDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Khoa> getListKhoa() {
        String sql = "select*from Khoa";
        return jdbcTemplate.query(sql,new KhoaMapper());
    }
}
