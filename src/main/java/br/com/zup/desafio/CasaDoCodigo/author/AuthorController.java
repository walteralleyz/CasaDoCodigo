package br.com.zup.desafio.CasaDoCodigo.author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDTO> create(@RequestBody @Valid AuthorDTO dto, UriComponentsBuilder builder) {
        Author author = dto.toModel();

        entityManager.persist(author);

        return ResponseEntity.ok().body(author.toDTO());
    }
}
