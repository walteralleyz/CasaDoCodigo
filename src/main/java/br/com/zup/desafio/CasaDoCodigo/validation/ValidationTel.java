package br.com.zup.desafio.CasaDoCodigo.validation;

import br.com.zup.desafio.CasaDoCodigo.interfaces.BRTel;
import br.com.zup.desafio.CasaDoCodigo.interfaces.CEP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationTel implements ConstraintValidator<BRTel, String> {

    @Override
    public void initialize(BRTel constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.equals(""))
            return false;

        Pattern pattern = Pattern.compile("\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}");
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }
}
