package com.goias.msusers.service;

public interface MailService {

    void sendEmail(String to, String subject, String text);

}
