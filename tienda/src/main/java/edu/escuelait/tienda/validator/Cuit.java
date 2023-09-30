package edu.escuelait.tienda.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CUITValidator.class)//Validador que implementa la interfaz
@Target( { ElementType.FIELD })//Especificamos que solo se puede usar en atributos java
@Retention(RetentionPolicy.RUNTIME)
public @interface Cuit {
  String message() default "Número de CUIT invalido"; //Mensaje de error
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}

