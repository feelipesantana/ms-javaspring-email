package com.ms.userms.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.userms.dtos.UserRecordDTO;
import com.ms.userms.models.UserModel;
import com.ms.userms.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDTO UserRecordDTO){
    
  
   UserModel userModel = new UserModel();
   BeanUtils.copyProperties(UserRecordDTO, userModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
  }
}
