package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Service.EmailService;

import java.security.SecureRandom;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    @Value("${spring.mail.username}") private String sender;
    @Override
    public String sendSimpleMail(String ToMail) {
        // Try block to check for exceptions
        String radom = randomString();
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(ToMail);
            mailMessage.setSubject("MÃ XÁC NHẬN HCMUNRE");
            mailMessage.setText("MÃ XÁC NHẬN LÀ: "+radom+"");
            // Sending the mail
            javaMailSender.send(mailMessage);
            System.out.println("Gửi mã xác nhận thành công..."); 
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi gửi mail");
        }
        return radom;
    }

    @Override
    public String sendMailWithAttachment() {
        return null;
    }
}
