package com.test1.art_test1.api.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Property of CODIX SA
 * Date: 5/27/2020 Time: 3:42 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@RestController
public class SmsResource {

    private final SmsService smsService;

    @Autowired
    public SmsResource(SmsService smsService) {
        this.smsService = smsService;
    }
}
