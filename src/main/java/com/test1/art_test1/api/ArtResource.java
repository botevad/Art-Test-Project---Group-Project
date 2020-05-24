package com.test1.art_test1.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Property of CODIX SA
 * Date: 4/15/2020 Time: 2:28 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@RestController
public class ArtResource {

  @GetMapping("/svc/get")
  @PreAuthorize("hasAuthority('C')")
  public String get() {
    return "Hello";
  }

  @GetMapping("/healthcheck")
  public String laod() {
    return "Ok";
  }
}
