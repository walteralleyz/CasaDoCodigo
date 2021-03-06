package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.exception.MissingValueException;
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

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientDTO dto, UriComponentsBuilder builder)
        throws MissingValueException {
        Client client = dto.toModel(entityManager);

        entityManager.persist(client);

        return ResponseEntity.ok().body(client.toDTO());
    }
}

