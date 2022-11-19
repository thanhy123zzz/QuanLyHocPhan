package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.Mapper.LopHocPhanMapper;
import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        else if (dotHoc.contains("full")){
            sql = "SELECT * FROM quanlyhocphan.lophocphan";
        }
        else {
            sql = "SELECT * FROM quanlyhocphan.lophocphan where DotHoc = '" + dotHoc + "'";
        }
        return jdbcTemplate.query(sql,new LopHocPhanMapper());
    }
    // xd add 
    @Override
    public List<LopHocPhan> getListByMaSVandMaCN(String masv){
        // String sql = "select lhp.`MaLop`,lhp.`TenLop`,lhp.`MaxSV`,lhp.`DotHoc`,lhp.`MaLichHoc`,lhp.`MaGiaoVien`,lhp.`MaPhong`,lhp.`MaHP`,lhp.`TrangThai`"+
        // " from lophocphan lhp join hocphan hp on hp.MaHP = lhp.MaHP"+
        // " join khoa k on k.MaKhoa = hp.MaKhoa join chuyennganh cn on cn.MaKhoa = cn.MaKhoa join sinhvien sv on sv.MaChuyenNganh = cn.MaChuyenNganh"+
        // " where cn.MaChuyenNganh = '"+maCN+"' and sv.masv = '"+masv+"';";

        String sql = "select * from sinhvien sv,chuongtrinhdaotao ctdt, hocphanctdt hpctdt, lophocphan lh"+
        " where sv.Machuyennganh = ctdt.MaChuyenNganh and ctdt.MaCTDT = hpctdt.MaCTDT"+
        " and lh.MaHP = hpctdt.MaHP and sv.masv = '"+masv+"' and TrangThai = 0";
        return jdbcTemplate.query(sql, new LopHocPhanMapper());
    }
    /* end*/ 

    @Override
    public LopHocPhan getLopHocPhan(int MaLop) {
        String sql = "select*from lophocphan where malop = "+ MaLop;
        return jdbcTemplate.query(sql,new LopHocPhanMapper()).get(0);
    }

    @Override
    public String insertLopHocPhan(LopHocPhan lopHocPhan, String dotHoc) {
        String sql = "INSERT INTO `quanlyhocphan`.`lophocphan` (`TenLop`, `MaxSV`, `DotHoc`, `MaLichHoc`, `MaGiaoVien`, `MaPhong`, `MaHP`,`TrangThai`) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        int kq = jdbcTemplate.update(sql,lopHocPhan.getTenLop(),lopHocPhan.getMaxSV(),dotHoc,lopHocPhan.getLichHoc().getMaLichHoc(),lopHocPhan.getGiaoVien().getMaGV(),lopHocPhan.getPhongHoc().getMaPhong(),lopHocPhan.getHocPhan().getMaHocPhan(),false);
        if(kq>0)
        {
            return "Thành công";
        }
        return "Thất bại";
    }

}
