package br.com.zup.desafio.CasaDoCodigo.author;

import br.com.zup.desafio.CasaDoCodigo.interfaces.Singular;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private final LocalDateTime createdAt;

    public AuthorDTO(@NotBlank String name,
                     @NotBlank @Email String email,
                     @NotBlank @Size(max = 400) String description,
                     @NotNull LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Author toModel() {
        return new Author(name, email, description, createdAt);
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
