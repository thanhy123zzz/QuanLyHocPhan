package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.NamHocHocKyDao;
import com.example.quanlyhocphan.Entities.Mapper.NamHocHocKyMapper;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class NamHocHocKyDaoImp implements NamHocHocKyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public NamHocHocKy getNamHocHocKy(Date dotHoc){
        String sql = "select*from NamHocHocKy where DotHoc ='"+dotHoc+"'";
        return jdbcTemplate.query(sql,new NamHocHocKyMapper()).get(0);
    }

    @Override
    public List<NamHocHocKy> getListNamHoc() {
        String sql = "select*from namhochocky order by DotHoc desc";
        return jdbcTemplate.query(sql,new NamHocHocKyMapper());
    }


}
