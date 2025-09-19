package com.tanko.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger API")
                        .version("1.0")
                        .description("REST API java"))
                .servers(List.of(
                        new Server().url("/")
//        new Server().url("http://localhost:8080")
                ));
    }
}
