/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.seguridad;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .info(new Info().title("InfiniHR API").version("v1"))
        .schemaRequirement("basicAuth",
            new SecurityScheme().name("basicAuth").type(SecurityScheme.Type.HTTP).scheme("basic"))
        .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
  }
}
