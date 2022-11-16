package com.example.quanlyhocphan.Service;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(String ToMail);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment();
}
