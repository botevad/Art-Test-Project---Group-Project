package com.test1.art_test1.api.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Property of CODIX SA
 * Date: 5/27/2020 Time: 3:43 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Service
public class SmsService {
    private final SmsDao smsDao;

    @Autowired
    public SmsService(SmsDao smsDao) {
        this.smsDao = smsDao;
    }
}
