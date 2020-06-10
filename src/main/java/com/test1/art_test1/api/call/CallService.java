package com.test1.art_test1.api.call;

import org.springframework.stereotype.Service;

@Service
public class CallService {
    private final CallDao callDao;

    public CallService(CallDao callDao) {
        this.callDao = callDao;
    }
}
