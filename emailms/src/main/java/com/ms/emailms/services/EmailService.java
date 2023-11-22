package com.ms.emailms.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.emailms.enums.StatusEmail;
import com.ms.emailms.models.EmailModel;
import com.ms.emailms.repositories.EmailRepository;

import jakarta.transaction.Transactional;


@Service
public class EmailService {
  
  @Autowired
  EmailRepository emailRepository;

  @Autowired
  JavaMailSender emailSender;

  @Value(value = "${spring.mail.username}")
  private String emailFrom;

  @Transactional
  public EmailModel sendEmail(EmailModel emailModel){
    try{
      emailModel.setSentDateEmail(LocalDateTime.now());
      emailModel.setEmailFrom(emailFrom);

      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());
      emailSender.send(message);

      emailModel.setStatusEmail((StatusEmail.SENT));
    }catch(Exception err){
      emailModel.setStatusEmail(StatusEmail.ERROR);
      
    }finally{
      return emailRepository.save(emailModel);
    }
  }
}
