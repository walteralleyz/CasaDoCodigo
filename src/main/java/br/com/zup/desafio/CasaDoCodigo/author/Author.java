package br.com.zup.desafio.CasaDoCodigo.author;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private final String name;

    @Column(unique = true)
    private final String email;

    @Column(length = 400)
    private final String description;

    private final LocalDateTime createdAt;

    public Author(String name,
                  String email,
                  String description,
                  LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public AuthorDTO toDTO() {
        AuthorDTO dto = new AuthorDTO(name, email, description);
        dto.setCreatedAt(createdAt);

        return dto;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
