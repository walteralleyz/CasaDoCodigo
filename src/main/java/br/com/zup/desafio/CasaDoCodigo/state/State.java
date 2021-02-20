package br.com.zup.desafio.CasaDoCodigo.state;

import br.com.zup.desafio.CasaDoCodigo.country.Country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "states", uniqueConstraints = {@UniqueConstraint(columnNames = {"country_id", "name"})})
public class State {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private final Country country;

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public StateResponseDTO toDTO() {
        return new StateResponseDTO(
            name,
            country
        );
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
