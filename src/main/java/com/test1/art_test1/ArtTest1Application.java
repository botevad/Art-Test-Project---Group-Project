package com.test1.art_test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.Collections;

@SpringBootApplication
@EnableWebMvc
public class ArtTest1Application {

	public static void main(String[] args) throws IOException {

		//System.getProperties().put( "server.port", 8183 );
		SpringApplication app = new SpringApplication(ArtTest1Application.class);
		app.run(args);

		System.out.println("Hit 'Enter' to terminate");
		System.in.read();
	}

}
