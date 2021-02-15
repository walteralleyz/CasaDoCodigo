package br.com.zup.desafio.CasaDoCodigo.exception;

public class MissingValueException extends Exception {
    private final String field;

    public MissingValueException(String field) {
        super(String.format("Você precisa preencher o valor %s", field));

        this.field = field;
    }

    public String getField() {
        return field;
    }
}
