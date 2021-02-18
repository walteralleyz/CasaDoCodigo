package br.com.zup.desafio.CasaDoCodigo.book;

import br.com.zup.desafio.CasaDoCodigo.interfaces.Exists;
import br.com.zup.desafio.CasaDoCodigo.interfaces.Singular;
import br.com.zup.desafio.CasaDoCodigo.author.Author;
import br.com.zup.desafio.CasaDoCodigo.category.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDTO {
    @NotBlank
    @Singular(domainClass = Book.class, fieldName = "isbn")
    private final String isbn;

    @NotBlank
    @Singular(domainClass = Book.class, fieldName = "title")
    private final String title;

    @NotBlank
    @Size(max = 500)
    private final String content;

    private String summary;

    @NotNull
    @Min(20)
    private final BigDecimal price;

    @NotNull
    @Min(100)
    private final Integer pageLength;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private final LocalDate launchDate;

    @NotNull
    @Exists(domainClass = Category.class, fieldName = "id")
    @Min(value = 1)
    private final Integer category_id;

    @NotNull
    @Exists(domainClass = Author.class, fieldName = "id")
    @Min(value = 1)
    private final Integer author_id;

    public BookDTO(@NotBlank String isbn,
                   @NotBlank String title,
                   @NotBlank @Size(max = 500) String content,
                   @NotNull @Min(20) BigDecimal price,
                   @NotNull @Min(100) Integer pageLength,
                   @NotNull LocalDate launchDate,
                   @NotNull Integer category_id,
                   @NotNull Integer author_id,
                   String summary) {
        this.isbn = isbn;
        this.title = title;
        this.content = content;
        this.price = price;
        this.pageLength = pageLength;
        this.launchDate = launchDate;
        this.summary = summary;
        this.category_id = category_id;
        this.author_id = author_id;
    }

    public Book toModel(EntityManager em) {
        return new Book(
            isbn,
            title,
            content,
            price,
            pageLength,
            launchDate,
            em.find(Category.class, this.category_id),
            em.find(Author.class, this.author_id),
            summary
        );
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPageLength() {
        return pageLength;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }
}
