package br.com.wombo.email.emailservice.core;

public record EmailRequest(String to, String subject, String body) {
}
