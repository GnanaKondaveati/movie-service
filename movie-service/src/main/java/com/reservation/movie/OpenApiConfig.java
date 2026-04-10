package com.reservation.movie;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info(){}
                        .title("Movie Service API")
                        .version("1.0")
                        .description("This is the documentation for the Movie Service application.")
                        .contact(new Contact().name("Support Team").email("support@example.com")));
    }
}
