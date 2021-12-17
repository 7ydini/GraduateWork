package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

@Service
public interface EmailService {
    public void sendSimpleEmail(String toAddress, String subject, String message);
    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;
}
