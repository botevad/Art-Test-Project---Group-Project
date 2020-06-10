package com.test1.art_test1.api.email;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailResource {
    private final EmailService emailService;

    public EmailResource(EmailService emailService) {
        this.emailService = emailService;
    }
}
