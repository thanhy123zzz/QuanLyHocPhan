package com.example.quanlyhocphan.Entities.Mapper;

import org.springframework.jdbc.core.RowMapper;

import com.example.quanlyhocphan.Entities.Accounts;

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
