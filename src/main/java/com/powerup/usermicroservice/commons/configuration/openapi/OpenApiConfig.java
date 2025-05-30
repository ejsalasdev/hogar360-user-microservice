package com.powerup.usermicroservice.commons.configuration.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "👤 User Microservice API",
                version = "v1.0.0",
                description = """
                        **Microservicio de gestión de usuarios para la plataforma Hogar360**
                        
                        Este microservicio maneja la autenticación, autorización y gestión de usuarios 
                        con roles ADMIN, SELLER y BUYER. Implementa arquitectura hexagonal y DDD.
                        
                        ## Características principales:
                        - ✅ Autenticación JWT
                        - ✅ Roles y permisos granulares  
                        - ✅ Validaciones de negocio robustas
                        - ✅ Arquitectura hexagonal + DDD
                        - ✅ Seguridad con Spring Security
                        
                        ## Credenciales por defecto:
                        - **Admin**: admin@sistema.com / admin123
                        """,
                contact = @Contact(
                        name = "Equipo de Desarrollo Hogar360",
                        email = "dev@hogar360.com",
                        url = "https://github.com/hogar360"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        description = "Desarrollo Local",
                        url = "http://localhost:8082"
                ),
                @Server(
                        description = "Producción",
                        url = "https://api.hogar360.com"
                )
        },
        security = @SecurityRequirement(name = "Bearer Authentication")
)
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = """
                **Autenticación JWT**
                
                Para acceder a los endpoints protegidos, debe incluir un token JWT válido.
                
                **Pasos:**
                1. Haga login en `/api/v1/auth/login` con credenciales válidas
                2. Copie el token del response
                3. Click en 'Authorize' y pegue: `Bearer {su-token}`
                
                **Formato del header:**
                `Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...`
                """
)
public class OpenApiConfig {
}
