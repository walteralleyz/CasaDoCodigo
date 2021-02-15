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
    @NotBlank
    private String isbn;

    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String content;

    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer pageLength;

    private LocalDate launchDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @NotNull
    @JoinColumn(name = "author_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Author author;

    public Book() {}

    public Book(@NotBlank  String isbn,
                @NotBlank String title,
                @NotBlank @Size(max = 500) String content,
                @NotNull @Min(20) BigDecimal price,
                @NotNull @Min(100) Integer pageLength,
                LocalDate launchDate,
                @NotNull Category category,
                @NotNull Author author,
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
