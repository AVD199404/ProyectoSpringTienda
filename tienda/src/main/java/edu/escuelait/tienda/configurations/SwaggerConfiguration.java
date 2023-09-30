package edu.escuelait.tienda.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
info =@Info(
        title="Tienda escuela IT API",
        description="Tienda escuela API Microservicio",
        contact= @Contact(
                name="Alejandro Vale",
                url="http://escuelaita.es",
                email="alejandrojosevaled@gmail.com"
        ),
        license= @License(
                name= "MTI license")),
        servers= @Server(url="http://localhost8080")





)
public class SwaggerConfiguration {

}
