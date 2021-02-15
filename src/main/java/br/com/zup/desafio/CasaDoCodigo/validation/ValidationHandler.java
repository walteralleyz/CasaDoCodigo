package br.com.zup.desafio.CasaDoCodigo.validation;

import br.com.zup.desafio.CasaDoCodigo.exception.MissingValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingValueException.class)
    public ValidationSimpleMessage handleStateException(MissingValueException e) {
        return new ValidationSimpleMessage(
            e.getField(),
            e.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public List<ValidationSimpleMessage> handleBindException(BindException e) {
        List<FieldError> fe = e.getBindingResult().getFieldErrors();

        return fe.stream().map(field -> new ValidationSimpleMessage(
                field.getField(),
                getErrorMessage(field)
        )).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationSimpleMessage> handleValidationException(MethodArgumentNotValidException e) {
        return handleBindException(e);
    }

    public String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
