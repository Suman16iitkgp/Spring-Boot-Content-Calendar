package com.Suman16iitkgp.contentCalendar.config;

import com.Suman16iitkgp.contentCalendar.controller.ContentController;
import com.Suman16iitkgp.contentCalendar.model.Content;
import com.Suman16iitkgp.contentCalendar.model.Status;
import com.Suman16iitkgp.contentCalendar.model.Type;
import com.Suman16iitkgp.contentCalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Configuration
public class MyWebConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
        return args -> {
            Content content = new Content(null, "Blog Post 2", "Blog Post 2", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "");
            contentRepository.save(content);
        };
    }
}
