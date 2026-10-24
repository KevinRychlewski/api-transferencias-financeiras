package com.Rychlewski.DesafioItauFinancia.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Transferências Financeiras",
        version = "1.0",
        description = "API REST para transferências entre contas, com lock pessimista e idempotência"
    )
)
public class OpenApiConfig {

}
