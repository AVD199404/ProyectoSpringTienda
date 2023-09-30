package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.escuelait.tienda.validator.Cuit;
import edu.escuelait.tienda.validator.groups.OnCreate;
import edu.escuelait.tienda.validator.groups.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Schema(description = "Datos de la persona")
@JsonPropertyOrder({"name","id","lastname","cuit","direction"})
public class Persona {
    @NonNull
    @Schema(description = "ID para identificación de la persona")
    private Long id;
    @NonNull //Que tiene que esta dentro del metodo constructor
    @Schema(description = "Nombre de la persona")
    @JsonProperty("nombre")
    private String name;

    @NonNull
    @NotNull (groups= OnUpdate.class) //Que la variable no puede ser nula
    @Schema(description = "Apellido de la persona")
    @JsonProperty("casa")
    private String lastName;

    @NotBlank (groups=OnCreate.class)//La variable no puede ser nula ni vacia
    @Size(min = 3, max = 6) //Minimo 3 caracteres, maximo 6 caracteres
    private String direction;


    @Cuit
    private String cuit;
//
//    @Max(69)
//    @Min(18)
//    private int edad;
//
//    @AssertFalse //El valor tiene que ser falso
//    private boolean single;
//
//    @Email
//    private String email;
//
//    @Positive
//    private int puntacion;
//
//    @Negative
//    private int ranking;
//
//    @Past
//    private LocalDate fechaDeNacimiento;
//
//    @FutureOrPresent
//    private LocalDate registro;

/**
 public Long getId() {
 return id;
 }

 public void setId(Long id) {
 this.id = id;
 }

 public String getName() {
 return name;
 }

 public void setName(String name) {
 this.name = name;
 }

 public String getLastName() {
 return lastName;
 }

 public void setLastName(String lastName) {
 this.lastName = lastName;
 }

 @Override public String toString() {
 return "Esta persona se llama "+this.name+ " "+this.lastName;
 }
 **/
}
