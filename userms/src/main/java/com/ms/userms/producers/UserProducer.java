package com.ms.userms.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.userms.dtos.EmailDTO;
import com.ms.userms.models.UserModel;

@Component
public class UserProducer {
  
  @Autowired
  private RabbitTemplate rabbitTemplate;

  public UserProducer(RabbitTemplate rabbitTemplate){
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value(value = "${broker.queue.email.name}")
  private String routingKey;

  public void publishMessegeEmail(UserModel userModel){
    var emailDTO = new EmailDTO();
    emailDTO.setUserId(userModel.getUserId());
    emailDTO.setEmailTo(userModel.getEmail());
    emailDTO.setSubject("Cadatro realzado com sucesso!");
    emailDTO.setText(userModel.getName() + ", Seja Bem vindo(a)! \nAguradecemos o seu cadastro, aproveite agora  todos os recursos da nossa plataforma!");

    rabbitTemplate.convertAndSend("", routingKey, emailDTO);
  }
}
