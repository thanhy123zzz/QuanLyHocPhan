package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.CTDTDao;
import com.example.quanlyhocphan.Entities.CTDT;
import com.example.quanlyhocphan.Entities.Mapper.CTDTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CTDTDaoImp implements CTDTDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public CTDT getCTDT(String MaCTDT) {
        String sql = "select*from chuongtrinhdaotao where MaCTDT ='"+MaCTDT+"'";
        if (jdbcTemplate.query(sql,new CTDTMapper()).size()==0)
        {
            return null;
        }
        return jdbcTemplate.query(sql,new CTDTMapper()).get(0);
    }

    @Override
    public String insertCTDT(CTDT ctdt,String dothoc) {
        String sql = "insert into chuongtrinhdaotao values(?,?,?,?)";
        int kq = jdbcTemplate.update(sql,new Object[]{ctdt.getMaCTDT(),ctdt.getChuyenNganh().getMaChuyenNganh(),dothoc,ctdt.getNienkhoa()});
        if(kq!=0) return "Thành công";
        else return "Thất bại";
    }

    @Override
    public List<CTDT> getListCTDT() {
        return jdbcTemplate.query("select *from chuongtrinhdaotao",new CTDTMapper());
    }

    @Override
    public List<CTDT> getbyMaSV(String masv){
        String sql = "select dt.mactdt,dt.machuyennganh,dt.dothoc,dt.nienkhoa from "+
        " chuongtrinhdaotao dt join chuyennganh cn on cn.machuyennganh = dt.machuyennganh join sinhvien sv on cn.machuyennganh = sv.machuyennganh"+ 
        " where sv.masv = '"+masv+"' order by dt.dothoc asc;";
        return jdbcTemplate.query(sql, new CTDTMapper());
    }
}
