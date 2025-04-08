package com.powerup.usermicroservice.commons.configuration.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User Microservice API",
        version = "v1.0.0",
        description = "API for managing users in the hogar360 platform"))
public class OpenApiConfig {
}
