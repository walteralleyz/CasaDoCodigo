package br.com.zup.desafio.CasaDoCodigo.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryDTO dto, UriComponentsBuilder builder) {
        Category category = dto.toModel();

        entityManager.persist(category);
        URI uri = builder.path("/api/category/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category.toDTO());
    }
}
