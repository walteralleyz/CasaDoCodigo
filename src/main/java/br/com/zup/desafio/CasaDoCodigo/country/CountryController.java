package br.com.zup.desafio.CasaDoCodigo.country;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<CountryDTO> create(@RequestBody @Valid CountryDTO dto, UriComponentsBuilder builder) {
        Country country = dto.toModel();

        entityManager.persist(country);
        URI uri = builder.path("/api/country/{id}").buildAndExpand(country.getId()).toUri();

        return ResponseEntity.created(uri).body(country.toDTO());
    }
}
