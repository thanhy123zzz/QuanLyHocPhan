package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.AccountsDao;
import com.example.quanlyhocphan.Entities.Accounts;
import com.example.quanlyhocphan.Entities.Mapper.AccountsMapper;

import com.example.quanlyhocphan.Entities.Mapper.RoleMapper;
import com.example.quanlyhocphan.Entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountsImp implements AccountsDao {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Override
    public Accounts checkAccount(String username) {
        String query = "select * from accounts where TaiKhoan = '"+username+"'";
        List<Accounts> list = new ArrayList<Accounts>();
        list = jdbctemplate.query(query,new AccountsMapper());
        Accounts accounts = list.get(0);
        accounts.setRole(getrole(accounts.getMaRole()));
        if(list.size()==1)return accounts;
        else return null;
    }

    public Role getrole(String marole){
        String sql = "select*from roles where marole = '"+marole+"'";
        return jdbctemplate.query(sql,new RoleMapper()).get(0);
    }
    @Override
    public int insertAccount(Accounts accounts) {
        String query = "insert into accounts(TaiKhoan,MatKhau,IDrole) values(?,?,?)";
        return jdbctemplate.update(query,new Object[]{accounts.getTaiKhoan(),accounts.getMatKhau(),accounts.getMaRole()});
    }

    @Override
    public List<Accounts> showList(){
        String sql = "SELECT * FROM accounts";
        List<Accounts> list = jdbctemplate.query(sql,new AccountsMapper());
        return list;
    }
    @Override
    public List<Accounts> getListByEmailEdu(String email){
        String sql = "select ac.taikhoan, ac.matkhau, ac.marole from accounts ac join sinhvien sv on ac.TaiKhoan = sv.TaiKhoan Where sv.EmailEdu = '"+email+"'";
        return jdbctemplate.query(sql, new AccountsMapper());
    }
    @Override
    public int updatePassWord(String matkhau, String taikhoan){
       String sql = "UPDATE `quanlyhocphan`.`accounts` SET `MatKhau` = '"+matkhau+"' WHERE `TaiKhoan` = '"+taikhoan+"';";
        return jdbctemplate.update(sql);
    }
}
