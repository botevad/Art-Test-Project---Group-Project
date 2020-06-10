package com.test1.art_test1.api.call;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallResource {
    private final CallService callService;

    public CallResource(CallService callService) {
        this.callService = callService;
    }
}
