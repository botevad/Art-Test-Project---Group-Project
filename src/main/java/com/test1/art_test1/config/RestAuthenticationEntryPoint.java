package com.test1.art_test1.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Property of CODIX SA
 * Date: 4/19/2020 Time: 8:09 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        response.setHeader(HttpHeaders.WWW_AUTHENTICATE, "ImxAuth realm=\"imx\"");
    }
}
