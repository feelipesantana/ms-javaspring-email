package com.ms.emailms.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.emailms.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID>{
  
}
