package com.example.demo.Ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public Printer myPrint(){
      return new HpPrinter();
    }


}
