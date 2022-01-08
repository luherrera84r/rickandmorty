package com.mobdev.rickandmorty.application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rickandmorty.properties")
public class Properties {

}
