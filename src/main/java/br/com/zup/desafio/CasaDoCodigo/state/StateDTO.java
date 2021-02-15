package br.com.zup.desafio.CasaDoCodigo.state;

import br.com.zup.desafio.CasaDoCodigo.annotation.Exists;
import br.com.zup.desafio.CasaDoCodigo.annotation.UniqueState;
import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.exception.MissingValueException;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateDTO {
    @NotBlank
    @UniqueState(domainClass = State.class, fieldName = "name")
    private final String name;

    @NotNull
    @Exists(domainClass = Country.class, fieldName = "id")
    @Min(value = 1)
    private final Integer country_id;

    public StateDTO(@NotBlank String name, @NotNull Integer country_id) {
        this.name = String.format("%s:%d", name, country_id);
        this.country_id = country_id;
    }

    public State toModel(EntityManager em) {
        return new State(
            name.split(":")[0],
            em.find(Country.class, country_id)
        );
    }

    public String getName() {
        return name;
    }

    public Integer getCountry_id() {
        return country_id;
    }
}
