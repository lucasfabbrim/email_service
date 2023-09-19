package br.com.wombo.email.emailservice.adapters;

public interface EmailSenderGatwey {

    public void sendMail(String to, String subject, String body);

}
