package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service("astronautas")
@ConditionalOnProperty(prefix = "implementacion",value = "personas",havingValue = "astrounautas")
public class PersonasServiceImpl implements PersonasService {
    //Almacen de datos de pruebas
    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Amstrong","Marcelo"),
                    new Persona(2L,"Aldrin","Crespo"),
                    new Persona(3L,"Collins","TheBigHorse")));

    public PersonasServiceImpl() {
        log.info("Ejecutando construtor de PersonasServiceImpl");
    }
    @Override
    public List<Persona> listAllPersonas() {
        return this.personas;
    }
}
