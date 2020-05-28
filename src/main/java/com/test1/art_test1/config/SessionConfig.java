package com.test1.art_test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Property of CODIX SA
 * Date: 4/15/2020 Time: 10:18 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Configuration
public class SessionConfig extends SpringHttpSessionConfiguration {

  @Bean
  public MapSessionRepository sessionRepository() {
    final Map<String, Session> sessions = new HashMap<>();
    return new MapSessionRepository(sessions);
  }

  @Bean
  public HttpSessionStrategy httpSessionStrategy() {
    return new HeaderHttpSessionStrategy();
  }

  @Bean
  public HttpSessionIdResolver httpSessionIdResolver() {
    return HeaderHttpSessionIdResolver.xAuthToken();
  }
}
