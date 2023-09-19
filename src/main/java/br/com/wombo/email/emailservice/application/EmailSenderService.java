package br.com.wombo.email.emailservice.application;

import br.com.wombo.email.emailservice.adapters.EmailSenderGatwey;
import br.com.wombo.email.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGatwey emailSenderGatwey;

    @Autowired
    public EmailSenderService(EmailSenderGatwey emailSenderGatwey){
        this.emailSenderGatwey = emailSenderGatwey;
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        this.emailSenderGatwey.sendMail(to, subject, body);
    }
}
