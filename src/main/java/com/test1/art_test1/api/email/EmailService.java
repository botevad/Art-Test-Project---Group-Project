package com.test1.art_test1.api.email;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final EmailDao emailDao;

    public EmailService(EmailDao emailDao) {
        this.emailDao = emailDao;
    }
}
