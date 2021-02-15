package br.com.zup.desafio.CasaDoCodigo.annotation;

import br.com.zup.desafio.CasaDoCodigo.validation.ValidationUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationUnique.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Singular {
    String message() default "{br.com.zup.desafio.CasaDoCodigo.annotation.Singular}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
