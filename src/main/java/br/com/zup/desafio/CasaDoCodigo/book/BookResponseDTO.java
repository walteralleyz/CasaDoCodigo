package br.com.zup.desafio.CasaDoCodigo.book;

import br.com.zup.desafio.CasaDoCodigo.author.Author;
import br.com.zup.desafio.CasaDoCodigo.category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponseDTO {
    private final String isbn;
    private final String title;
    private final String content;
    private final String summary;
    private final BigDecimal price;
    private final Integer pageLength;
    private final LocalDate launchDate;
    private final Category category;
    private final Author author;


    public BookResponseDTO(String isbn,
                           String title,
                           String content,
                           String summary,
                           BigDecimal price,
                           Integer pageLength,
                           LocalDate launchDate,
                           Category category,
                           Author author) {
        this.isbn = isbn;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.price = price;
        this.pageLength = pageLength;
        this.launchDate = launchDate;
        this.category = category;
        this.author = author;
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
