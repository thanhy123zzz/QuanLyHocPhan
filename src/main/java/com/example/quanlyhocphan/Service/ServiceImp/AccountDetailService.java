package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.AccountsDao;
import com.example.quanlyhocphan.Dao.DaoImp.AccountsImp;
import com.example.quanlyhocphan.Entities.Accounts;
import com.example.quanlyhocphan.Service.ManagerService;

// import com.example.quanlyhocphan.DAO.TinTucDao;
// import com.example.quanlyhocphan.Model.Accounts;
// import com.example.quanlyhocphan.Model.TinTuc;
// import com.example.quanlyhocphan.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailService implements UserDetailsService, ManagerService {
    @Autowired
    private AccountsImp accountsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Accounts accounts = accountsDao.checkAccount(username);

        if (accounts == null) {
            new UsernameNotFoundException("Loign fail!");
        } else {

            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("RL02");
            grantList.add(authority);
            UserDetails user = User
                    .withUsername(accounts.getTaiKhoan())
                    .password(accounts.getMatKhau())
                    .roles(accounts.getMaRole())
                    .build();
            return user;
        }
        return null;
    }

    @Override
    public int insertAccount(Accounts accounts) {
        return accountsDao.insertAccount(accounts);
    }

    @Override
    public boolean checkAccount(String userName) {
        return accountsDao.checkAccount(userName) == null;
    }

    @Override
    public List<Accounts> showList() {
        return accountsDao.showList();
    }

    @Override
    public List<Accounts> getListByEmailEdu(String email){
        return accountsDao.getListByEmailEdu(email);
    }

    @Override
    public int updatePassWord(String matkhau, String taikhoan){
        return accountsDao.updatePassWord(matkhau, taikhoan);
    }
}
