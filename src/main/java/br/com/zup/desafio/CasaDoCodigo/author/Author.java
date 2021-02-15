package br.com.zup.desafio.CasaDoCodigo.author;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    @NotNull
    private LocalDateTime createdAt;

    public Author() {}

    public Author(@NotBlank String name,
                  @NotBlank @Email String email,
                  @NotBlank @Size(max = 400) String description,
                  @NotNull LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public AuthorDTO toDTO() {
        return new AuthorDTO(name, email, description, createdAt);
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
