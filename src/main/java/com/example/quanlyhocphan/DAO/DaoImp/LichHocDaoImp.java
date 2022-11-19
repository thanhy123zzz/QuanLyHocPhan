package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.LichHocDao;
import com.example.quanlyhocphan.Entities.LichHoc;
import com.example.quanlyhocphan.Entities.Mapper.LichHocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LichHocDaoImp implements LichHocDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public LichHoc getLichHoc(String maLichHoc) {
        String sql = "select*from LichHoc where MaLichHoc ='"+maLichHoc+"'";
        return jdbcTemplate.query(sql,new LichHocMapper()).get(0);
    }

    @Override
    public List<LichHoc> getlistLichHoc() {
        return jdbcTemplate.query("select*from lichhoc",new LichHocMapper());
    }


}
