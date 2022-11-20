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

    @Override
    public List<LopHocPhan> getListLopHocPhansByMaSV(String masv){
        String sql = "select distinct lhp.`MaLop`,lhp.`TenLop`,lhp.`MaxSV`,lhp.`DotHoc`,lhp.`MaLichHoc`,lhp.`MaGiaoVien`,lhp.`MaPhong`,lhp.`MaHP`,lhp.`TrangThai` from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
        " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lhp.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
        " and dk.masv = '"+masv+"'";
        return jdbcTemplate.query(sql, new LopHocPhanMapper());
    }

    @Override
    public List<LopHocPhan> getListLopHocPhanByDotHoc(String dotHoc,String masv) {
        String sql;
        if(dotHoc.contains("xxxxxxxxxxxxxx")){
            sql = "select distinct lhp.`MaLop`,lhp.`TenLop`,lhp.`MaxSV`,lhp.`DotHoc`,lhp.`MaLichHoc`,lhp.`MaGiaoVien`,lhp.`MaPhong`,lhp.`MaHP`,lhp.`TrangThai` from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
        " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lhp.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
        " and dk.masv = '"+masv+"'";
        }
        else{
            // sql = "select lhp.`MaLop`,lhp.`TenLop`,lhp.`MaxSV`,lhp.`DotHoc`,lhp.`MaLichHoc`,lhp.`MaGiaoVien`,lhp.`MaPhong`,lhp.`MaHP`,lhp.`TrangThai` from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
            // " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lh.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
            // " and dk.masv = '"+masv+"' and lhp.DotHoc = '" + dotHoc+ "'";
            sql ="select distinct lhp.`MaLop`,lhp.`TenLop`,lhp.`MaxSV`,lhp.`DotHoc`,lhp.`MaLichHoc`,lhp.`MaGiaoVien`,lhp.`MaPhong`,lhp.`MaHP`,lhp.`TrangThai` from lichhoc lh,hocphan hp,lophocphan lhp,namhochocky nh,phonghoc p,cahoc ch, dangkylophocphan dk, sinhvien sv"+
            " where lhp.maphong = p.maphong and lhp.mahp = hp.mahp and lh.macahoc = ch.macahoc and lhp.dothoc = nh.dothoc and lhp.malichhoc = lh.malichhoc and dk.masv = sv.masv and dk.malop = lhp.malop"+
            " and nh.dothoc ='"+dotHoc+"' and sv.masv = '"+masv+"';";
        }
        return jdbcTemplate.query(sql,new LopHocPhanMapper());
    }

    public int doiMaxSV(int malop, int sl) {
        return jdbcTemplate.update("update Lophocphan set MaxSV = "+sl+" where malop = "+ malop);
    }

    @Override
    public String doiTrangThai(int maLop, boolean trangThai) {
        int kq = jdbcTemplate.update("update Lophocphan set TrangThai = "+trangThai+" where malop = "+ maLop);
        return kq>0?"Đổi trạng thái thành công":"Đổi trạng thái thất bại";
    }

}
