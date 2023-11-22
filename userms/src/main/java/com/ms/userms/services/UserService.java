package com.ms.userms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.userms.models.UserModel;
import com.ms.userms.producers.UserProducer;
import com.ms.userms.repositories.UserReposity;

import jakarta.transaction.Transactional;

@Service
public class UserService {

  @Autowired
  private UserReposity userRepository;

  @Autowired
  private UserProducer userProducer;

  
  @Transactional
  public UserModel save(UserModel userModel) {

    userModel = userRepository.save(userModel);
    userProducer.publishMessegeEmail(userModel);

    return userModel;
  }
}

