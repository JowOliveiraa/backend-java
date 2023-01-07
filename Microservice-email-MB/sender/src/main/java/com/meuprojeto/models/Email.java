package com.meuprojeto.models;

import com.meuprojeto.dtos.EmailDTO;
import com.meuprojeto.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "tb_email")
@NoArgsConstructor
public class Email implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Length(max = 50)
    private String ownerRef;
    @Length(max = 50)
    private String emailFrom;
    @Length(max = 50)
    private String emailTo;
    @Length(max = 100)
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail = LocalDateTime.now();
    private StatusEmail statusEmail;

    public Email(EmailDTO dto) {
        this.ownerRef = dto.getOwnerRef();
        this.emailFrom = dto.getEmailFrom();
        this.emailTo = dto.getEmailTo();
        this.subject = dto.getSubject();
        this.text = dto.getText();
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }
}
