package br.com.zup.desafio.CasaDoCodigo.state;

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
@RequestMapping("/api/state")
public class StateController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<StateResponseDTO> create(@RequestBody @Valid StateDTO dto, UriComponentsBuilder builder) {
        State state = dto.toModel(entityManager);

        entityManager.persist(state);
        URI uri = builder.path("/api/state/{id}").buildAndExpand(state.getId()).toUri();

        return ResponseEntity.created(uri).body(state.toDTO());
    }
}
