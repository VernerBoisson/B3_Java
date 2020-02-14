package com.ynov.api.clients;

import feign.Logger;
import feign.Logger.Level;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration
{
    public ClientConfiguration() {}

    @Bean
    Level feignLoggerLevel() { return Level.FULL;}

    @Bean
    public Logger logger(){ return new Slf4jLogger(); }
}
