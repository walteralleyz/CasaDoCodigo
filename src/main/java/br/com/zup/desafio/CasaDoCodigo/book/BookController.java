package br.com.zup.desafio.CasaDoCodigo.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<BookResponseDTO> create(@RequestBody @Valid BookDTO dto, UriComponentsBuilder builder) {
        Book book = dto.toModel(entityManager);

        entityManager.persist(book);

        return ResponseEntity.ok().body(book.toDTO());
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<BookResponseDTO>> bookList() {
        Query query = entityManager.createQuery("select b from Book b");
        List<Book> results = new ArrayList<>();
        List<?> temp = query.getResultList();

        if(temp.isEmpty())
            return ResponseEntity.noContent().build();

        temp.forEach(q -> results.add((Book) q));
        return ResponseEntity.ok(results.stream().map(Book::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<BookResponseDTO> getDetails(@PathVariable Integer id) {
        Book book = entityManager.find(Book.class, id);

        if(book == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(book.toDTO());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Integer id, @RequestBody BookDTO dto) {
        Book book = entityManager.find(Book.class, id);

        if(book == null)
            return ResponseEntity.badRequest().build();

        book = dto.toModel(entityManager);
        entityManager.persist(book);

        return ResponseEntity.ok(book.toDTO());
    }
}
