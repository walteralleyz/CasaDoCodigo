package br.com.zup.desafio.CasaDoCodigo.country;

import br.com.zup.desafio.CasaDoCodigo.interfaces.Singular;

import javax.validation.constraints.NotBlank;

public class CountryDTO {
    @NotBlank
    @Singular(domainClass = Country.class, fieldName = "name")
    private String name;

    public CountryDTO() {}

    public CountryDTO(@NotBlank String name) {
        this.name = name;
    }

    public Country toModel() {
        return new Country(name);
    }

    public String getName() {
        return name;
    }
}
