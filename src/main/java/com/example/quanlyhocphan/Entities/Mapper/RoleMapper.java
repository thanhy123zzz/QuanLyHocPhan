package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role r = new Role();
        r.setMaRole(rs.getString("MaRole"));
        r.setTenRole(rs.getString("TenRole"));
        return r;
    }
}
