package com.ms.userms.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.userms.models.UserModel;


public interface UserReposity extends JpaRepository<UserModel, UUID>
{
  
}
