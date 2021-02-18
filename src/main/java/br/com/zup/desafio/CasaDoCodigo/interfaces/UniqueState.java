package br.com.zup.desafio.CasaDoCodigo.interfaces;

import br.com.zup.desafio.CasaDoCodigo.validation.ValidationUniqueState;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationUniqueState.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueState {
    String message() default "{br.com.zup.desafio.CasaDoCodigo.annotation.UniqueState}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
