package com.lbr.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI readifyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("📚 Readify RESTful Bookstore API")
                        .version("1.0.0")
                        .description("API documentation for managing books and authors in Readify Bookstore"));
    }
}

