package br.com.zup.desafio.CasaDoCodigo.author;

import br.com.zup.desafio.CasaDoCodigo.interfaces.Singular;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuthorDTO {
    @NotBlank
    private final String name;

    @NotBlank
    @Email
    @Singular(domainClass = Author.class, fieldName = "email")
    private final String email;

    @NotBlank
    @Size(max = 400)
    private final String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    public AuthorDTO(@NotBlank String name,
                     @NotBlank @Email String email,
                     @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        return new Author(name, email, description, createdAt);
    }

    public void setCreatedAt(LocalDateTime date) {
        this.createdAt = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
