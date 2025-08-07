/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.config;

/**
 *
 * @author ruben
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("InfiniHR - API Backend")
                .version("1.0.0")
                .description("Documentación de la API de Recursos Humanos de InfiniHR.")
                .contact(new Contact()
                    .name("Equipo InfiniHR")
                    .email("teaminfinixdev@gmail.com")
                    .url("https://github.com/teaminfinixdev")  // O ponga su sitio cuando lo tenga
                )
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")
                )
            );
    }
}
