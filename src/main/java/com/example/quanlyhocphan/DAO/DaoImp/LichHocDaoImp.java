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

    @Override
    public List<LichHoc> getLisLichHocs(String masv){
        String sql = "select lh.malichhoc,lh.ngaybatdau,lh.ngayketthuc,lh.macahoc,lh.dothoc,lh.thu from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
        " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lh.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
        " and dk.masv = '"+masv+"';";
        return jdbcTemplate.query(sql, new LichHocMapper());
    }


}
