package com.amplify.accountmanager.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Santiago J. Valls.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan({"com.amplify.accountmanager"})
public class AccountManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountManagerApplication.class, args);
  }
}
