package br.com.zup.desafio.CasaDoCodigo.book;

import br.com.zup.desafio.CasaDoCodigo.author.Author;
import br.com.zup.desafio.CasaDoCodigo.category.Category;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private final String isbn;

    @Column(unique = true)
    private final String title;

    @Column(length = 500)
    private final String content;

    private String summary;

    private final BigDecimal price;

    private final Integer pageLength;

    private final LocalDate launchDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private final Category category;

    @JoinColumn(name = "author_id")
    @OneToOne(fetch = FetchType.EAGER)
    private final Author author;

    public Book(String isbn,
                String title,
                String content,
                BigDecimal price,
                Integer pageLength,
                LocalDate launchDate,
                Category category,
                Author author,
                String summary) {
        this.isbn = isbn;
        this.title = title;
        this.content = content;
        this.price = price;
        this.pageLength = pageLength;
        this.launchDate = launchDate;
        this.category = category;
        this.author = author;
        this.summary = summary;
    }

    public BookResponseDTO toDTO() {
        return new BookResponseDTO(
            isbn,
            title,
            content,
            summary,
            price,
            pageLength,
            launchDate,
            category,
            author
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

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
