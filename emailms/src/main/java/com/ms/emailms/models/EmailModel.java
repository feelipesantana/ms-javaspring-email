package com.ms.emailms.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ms.emailms.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="TB_EMAILS")
public class EmailModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID emailID;  
  private UUID userID;
  private String emailFrom;
  private String emailTo;
  private String subject;
  @Column(columnDefinition =  "TEXT")
  private String text;
  private LocalDateTime sentDateEmail;
  private StatusEmail statusEmail;
}
