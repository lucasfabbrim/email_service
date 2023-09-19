package br.com.wombo.email.emailservice.controller;

import br.com.wombo.email.emailservice.application.EmailSenderService;
import br.com.wombo.email.emailservice.core.EmailRequest;
import br.com.wombo.email.emailservice.core.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService senderService){
        this.emailSenderService = senderService;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderService.sendMail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("e-mail send successfully.");
        }catch (EmailServiceException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending e-mail.");

        }
    }

}
