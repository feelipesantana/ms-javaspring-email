package com.ms.emailms.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.emailms.dtos.EmailRecordDTO;
import com.ms.emailms.models.EmailModel;
import com.ms.emailms.services.EmailService;

@Component
public class EmailConsumer {
  
  @Autowired
  EmailService emailService;

  @RabbitListener(queues = "${broker.queue.email.name}")
  public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO){
    EmailModel emailModel = new EmailModel();

    BeanUtils.copyProperties(emailRecordDTO, emailModel);
    //sendEmail
    emailService.sendEmail(emailModel);

  }
}
