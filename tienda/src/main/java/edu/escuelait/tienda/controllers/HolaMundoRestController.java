package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="API Saludo",
        description = "Saludo a los usuarios")
public class HolaMundoRestController {

    @GetMapping("/Saludo/{user}")
    public String holaMundo(@PathVariable String user){

        return "Hola mundo Spring "+user;
    }
}
