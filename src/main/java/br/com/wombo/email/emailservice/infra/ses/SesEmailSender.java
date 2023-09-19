package br.com.wombo.email.emailservice.infra.ses;

import br.com.wombo.email.emailservice.adapters.EmailSenderGatwey;
import br.com.wombo.email.emailservice.core.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGatwey {


    private final AmazonSimpleEmailService simpleEmailService;

    public SesEmailSender(AmazonSimpleEmailService simpleEmailService){
        this.simpleEmailService = simpleEmailService;
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        SendEmailRequest sendEmailRequest = new SendEmailRequest()
                .withSource("lucasmendescontact@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message().withSubject(new Content(subject)).withBody(new Body().withText(new Content(body))));


        try{
            this.simpleEmailService.sendEmail(sendEmailRequest);
        }catch (AmazonServiceException ase){
            throw new EmailServiceException("Failure while send email.", ase);
        }

    }
}
