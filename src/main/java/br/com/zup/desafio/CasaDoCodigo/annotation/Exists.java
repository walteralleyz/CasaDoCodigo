package br.com.zup.desafio.CasaDoCodigo.annotation;

import br.com.zup.desafio.CasaDoCodigo.validation.ValidationExists;
import br.com.zup.desafio.CasaDoCodigo.validation.ValidationUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationExists.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {
    String message() default "{br.com.zup.desafio.CasaDoCodigo.annotation.Exists}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
