package edu.escuelait.tienda.services;

import edu.escuelait.tienda.configurations.TiendaPametrosConfig;
import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.helpers.ReportePDFImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Lazy
@Service("jugadores")
@ConditionalOnProperty(prefix = "implementacion",value = "personas",havingValue = "jugadores")

//@Primary
public class PersonasServiceJugadoresImpl implements  PersonasService{
  //  Almacen de datos de pruebas

    ReportePDFImpl reportePDF;




    ArrayList<Persona> jugadores = new ArrayList<>(
            List.of(new Persona(1L,"Maradona","LaSTANME"),
                    new Persona(2L,"Pique","new"),
                    new Persona(3L,"Levandovski","Something")));


    public PersonasServiceJugadoresImpl(ReportePDFImpl reportePDF) {
        this.reportePDF=reportePDF;
       log.info("Ejecutando construtor de PersonasServiceJugadoresImpl");
    }

    @Override
    public List<Persona> listAllPersonas() {
        this.reportePDF.generateReporPDF(this.jugadores);
        return this.jugadores;
    }
}