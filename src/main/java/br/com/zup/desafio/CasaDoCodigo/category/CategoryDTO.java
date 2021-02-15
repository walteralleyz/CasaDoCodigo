package br.com.zup.desafio.CasaDoCodigo.category;

import br.com.zup.desafio.CasaDoCodigo.annotation.Singular;
import javax.validation.constraints.NotBlank;

public class CategoryDTO {
    @NotBlank
    @Singular(domainClass = Category.class, fieldName = "name")
    private String name;

    public CategoryDTO() {}

    public CategoryDTO(@NotBlank String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(name);
    }

    public String getName() {
        return name;
    }
}
