package br.com.zup.desafio.CasaDoCodigo.interfaces;

import br.com.zup.desafio.CasaDoCodigo.validation.ValidationTel;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationTel.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BRTel {
    Class<?>[] groups() default {};
    String message() default "{br.com.zup.desafio.CasaDoCodigo.BRTel}";
    Class<? extends Payload>[] payload() default {};
}
