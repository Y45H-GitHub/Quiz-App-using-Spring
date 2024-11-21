package com.example.LoginDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Apply CORS only to /api endpoints
                        .allowedOrigins("http://127.0.0.1:5500/","http://127.0.0.1:5501/")  // Allow requests from your frontend's origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed HTTP methods
                        .allowedHeaders("*")  // Allow all headers
                        .allowCredentials(true);  // Allow credentials if needed
            }
        };
    }
}