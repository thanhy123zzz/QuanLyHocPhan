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

    @Override
    public List<NamHocHocKy> getListByMaSVCN(String masv){
        // String sql = "select distinct nh.NamHoc,nh.DotHoc,nh.HocKy from namhochocky nh,chuongtrinhdaotao ct, chuyennganh cn, hocphanctdt hpct, sinhvien sv,hocphan hp"+
        // " where nh.DotHoc = ct.DotHoc and ct.MaCTDT = hpct.MaCTDT and cn.MaChuyenNganh = ct.MaChuyenNganh and sv.MaChuyenNganh = cn.MaChuyenNganh and hp.MaHP = hpct.MaHP"+
        // " and sv.masv = '"+masv+"';";
        String sql = "select distinct nh.DotHoc,nh.hocky,nh.NamHoc  from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
        " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lhp.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
        " and sv.masv = '"+masv+"';";
        return jdbcTemplate.query(sql, new NamHocHocKyMapper());
    }


}
