package br.com.zup.desafio.CasaDoCodigo.category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public CategoryDTO toDTO() {
        return new CategoryDTO(name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
