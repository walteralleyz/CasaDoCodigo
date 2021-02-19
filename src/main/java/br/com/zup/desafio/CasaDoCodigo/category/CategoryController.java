package br.com.zup.desafio.CasaDoCodigo.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

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

        return ResponseEntity.ok().body(category.toDTO());
    }
}
