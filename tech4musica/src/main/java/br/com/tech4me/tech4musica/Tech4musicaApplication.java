package br.com.tech4me.tech4musica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Tech4musicaApplication {

	private static ConfigurableApplicationContext run;

	public static void main(String[] args) {
		run = SpringApplication.run(Tech4musicaApplication.class, args);
	}

}
