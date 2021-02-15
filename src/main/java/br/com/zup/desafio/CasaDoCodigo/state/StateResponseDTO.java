package br.com.zup.desafio.CasaDoCodigo.state;

import br.com.zup.desafio.CasaDoCodigo.country.Country;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateResponseDTO {
    private final String name;
    private final Country country;

    public StateResponseDTO(@NotBlank String name, @NotNull Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
