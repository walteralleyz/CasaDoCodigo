package br.com.zup.desafio.CasaDoCodigo.interfaces;

import br.com.zup.desafio.CasaDoCodigo.validation.ValidationCep;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationCep.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {
    Class<?>[] groups() default {};
    String message() default "{br.com.zup.desafio.CasaDoCodigo.CEP}";
    Class<? extends Payload>[] payload() default {};
}
