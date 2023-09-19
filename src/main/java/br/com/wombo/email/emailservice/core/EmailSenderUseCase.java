package br.com.wombo.email.emailservice.core;

public interface EmailSenderUseCase {

    public void sendMail(String to, String subject, String body);
}
