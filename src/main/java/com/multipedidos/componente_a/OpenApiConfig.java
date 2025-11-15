package com.multipedidos.componentea.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
            .group("componente-a-api") // Nombre del grupo de la API (puedes cambiarlo si quieres)
            .packagesToScan("com.multipedidos.componentea.controller") // Escanea solo los controladores del paquete correspondiente
            .pathsToMatch("/**") // Incluye todos los endpoints (si tienes controladores más específicos, ajusta las rutas aquí)
            .build();
    }
}
