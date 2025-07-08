package com.example.stumanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class configCORSconfig {
    @Bean
    public WebMvcConfigurer configurer()
    {

       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               //ADD CONFIGS
               registry.addMapping("/**")
                       .allowedOrigins("http://localhost:3002")
                       .allowedMethods("GET","DELETE","POST","PUT","PATCH","OPTIONS")
                       .allowedHeaders("*");
           }
       };
    }
}
