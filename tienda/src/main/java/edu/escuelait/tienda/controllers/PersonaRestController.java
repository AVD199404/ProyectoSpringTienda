package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.configurations.AppConfig;
import edu.escuelait.tienda.configurations.TiendaPametrosConfig;
import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.services.PersonasService;
import edu.escuelait.tienda.services.PersonasServiceImpl;
import edu.escuelait.tienda.validator.groups.OnCreate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/personas")
@Tag(name="API personas",
description = "CRUD de personas en tienda")
public class PersonaRestController {
  // @Autowired
   PersonasService personasService;
   AppConfig appConfig;
   TiendaPametrosConfig tiendaPametrosConfig;
 public PersonaRestController(@Lazy PersonasService personasService,
                                    AppConfig appConfig,
                                    TiendaPametrosConfig tiendaPametrosConfig) {
     log.info("AppConfig {}",appConfig);
     log.info("TiendaPametrosConfig {}",tiendaPametrosConfig);
            this.personasService = personasService;
         }
/**
    public PersonaRestController(@Qualifier("jugadores") @Lazy PersonasService personasService) {
        this.personasService = personasService;
    }

**/
    /**Otra forma de trabajar sin el Autowired es con el constructor, si trabajamos con el construsctor comentamos
     * el Autowired
    *
    * public PersonaRestController(PersonasService personasService) {
     *         this.personasService = personasService;
     *     }
    *
    *
    *
    * **/



  //  ArrayList<Persona> personas = new ArrayList<>(
    //        List.of(new Persona(1L,"Rafeal"),new Persona(2L,"Miguel"),new Persona(3L,"Alvaro")));
    @GetMapping("/{id}")
    @Operation(summary = "Recupera persona por id", description = "Recupera una persona dado un id de tipo numero")
    @ApiResponse(responseCode = "200", description = "operation existosa")
    @ApiResponse(responseCode = "400", description = "Error de petición")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<?> getPersonaById(@Parameter(description = "ID de de la persona", required = true, example = "1") @PathVariable Long id){
        if(id<=0){
           return ResponseEntity.badRequest().build();
        }
        for(Persona persona : personasService.listAllPersonas()){
            if(persona.getId().equals(id)){
                return ResponseEntity.ok(persona);
            }

        }

        return ResponseEntity.notFound().build();
    }
@GetMapping
    public ResponseEntity<?> listPersonas(){
    List<Persona> personas = personasService.listAllPersonas();
        return ResponseEntity.ok(personas);

    }
@PostMapping
    public ResponseEntity<?> createPersona(@RequestBody @Validated(OnCreate.class) Persona persona){
    personasService.listAllPersonas().add(persona);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(persona.getId())
            .toUri();

    return ResponseEntity.created(location).build();
    }
@PutMapping
    public ResponseEntity<?> updatePersona(@RequestBody @Validated(OnCreate.class) Persona persona){
    for (Persona per : personasService.listAllPersonas()){
        //buscar a la persona solicitada
        if(per.getId().equals(persona.getId())){
            //Actualizamos los datos
            per.setName(persona.getName());
            per.setLastName(persona.getLastName());
            per.setDirection(persona.getDirection());
            return ResponseEntity.ok(persona);
        }
    }
    return ResponseEntity.notFound().build();
    }
@DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){
        for (Persona persona : personasService.listAllPersonas()){
            //buscar a la persona solicitada
            if(persona.getId().equals(id)){
                //borra la persona
                personasService.listAllPersonas().remove(persona);
                return ResponseEntity.noContent().build();

            }
        }
    return ResponseEntity.notFound().build();
    }
}
