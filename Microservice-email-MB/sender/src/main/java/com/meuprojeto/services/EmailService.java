package com.meuprojeto.services;

import com.meuprojeto.enums.StatusEmail;
import com.meuprojeto.models.Email;
import com.meuprojeto.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private  EmailRepository repository;

    @Autowired
    private  JavaMailSender sender;  // Essa interface contém os métodos para envio de email


    public Email sendEmail(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            sender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException exception) {

            email.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            return repository.save(email);
        }
    }
}
