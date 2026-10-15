package es.decroly.tienda_decroly.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "API de la Tienda Decroly",
        version = "1.0",
        description = "Catalogo de productos y familias de la tienda"))

public class OpenApiConfig {
}
