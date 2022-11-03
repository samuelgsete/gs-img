package br.com.samuel.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudConfig {

    @Bean
    @Scope("singleton")
    public Cloudinary config() {
        return new Cloudinary("cloudinary://689814511152418:usZp2NUWoFBkmCiAeAtTdFQpfsE@dt4bynswk");
    }
}