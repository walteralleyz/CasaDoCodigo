package br.com.zup.desafio.CasaDoCodigo.country;

import br.com.zup.desafio.CasaDoCodigo.state.State;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<State> state;

    public Country() {}

    public Country(@NotBlank String name) {
        this.name = name;
    }

    public static boolean hasStates(EntityManager em, Integer cid) {
        Query query = em.createQuery("select c from Country c join c.state cs where c.id = :v");
        query.setParameter("v", cid);

        Country country = (Country) query.getResultList().get(0);

        if(country == null)
            return false;

        return country.state.size() > 0;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryDTO toDTO() {
        return new CountryDTO(name);
    }
}
