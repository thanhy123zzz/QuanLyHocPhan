package com.example.quanlyhocphan.Model.Mapper;

import com.example.quanlyhocphan.Model.Accounts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsMapper implements RowMapper<Accounts> {
    @Override
    public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accounts accounts = new Accounts();
        accounts.setTaiKhoan(rs.getString("TaiKhoan"));
        accounts.setMatKhau(rs.getString("MatKhau"));
        accounts.setMaRole(rs.getString("MaRole"));
        return accounts;
    }
}
