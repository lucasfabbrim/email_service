package br.com.wombo.email.emailservice.core;

import br.com.wombo.email.emailservice.application.EmailSenderService;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String s) {
        super(s);
    }
    public EmailServiceException(String s, Throwable throwable){
        super(s, throwable);
    }
}
