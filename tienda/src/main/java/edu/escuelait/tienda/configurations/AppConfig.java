package edu.escuelait.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    String nombre;
    String description;
    String language;
    String version;

}
