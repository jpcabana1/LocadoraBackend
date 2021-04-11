package com.api.restfulApi.Configuration;


import com.api.restfulApi.Models.DTOS.Message;
import com.api.restfulApi.Repository.NativeQueryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }

    @Bean
    public NativeQueryRepository nativeQuery(){
        return new NativeQueryRepository();
    }

    @Bean
    public Message message(){return new Message();}
}
