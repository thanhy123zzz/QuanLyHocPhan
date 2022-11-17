package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import com.example.quanlyhocphan.Entities.*;
import com.example.quanlyhocphan.Entities.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class LopHocPhanDaoImp implements LopHocPhanDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<LopHocPhan> getListLopHocPhan(String dotHoc) {
        String sql;
        if(dotHoc==null){
            sql = "SELECT * FROM quanlyhocphan.lophocphan where DotHoc = (select max(DotHoc) from namhochocky);";
        }
        else {
            sql = "SELECT * FROM quanlyhocphan.lophocphan where DotHoc = '" + dotHoc + "'";
        }
        return jdbcTemplate.query(sql,new LopHocPhanMapper());
    }

}
