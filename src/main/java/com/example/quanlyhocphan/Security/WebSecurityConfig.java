


package com.example.quanlyhocphan.Security;

import com.example.quanlyhocphan.Service.ServiceImp.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    AccountDetailService accountServiceImp;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/logout","/manager/dist/**","/manager/static/**","/manager/images/**").permitAll()
                .antMatchers("/").access("hasAnyRole('RL01','RL02')")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/login?success=fail")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("TaiKhoan")
                .passwordParameter("MatKhau")
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(accountServiceImp);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}