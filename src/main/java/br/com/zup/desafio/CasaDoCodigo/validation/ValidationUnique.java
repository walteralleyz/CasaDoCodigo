package br.com.zup.desafio.CasaDoCodigo.validation;

import br.com.zup.desafio.CasaDoCodigo.annotation.Singular;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidationUnique implements ConstraintValidator<Singular, Object> {
    private String domain;
    private Class<?> cls;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(
                String.format("select 1 from %s where %s = :value", cls.getName(), domain)
        );

        query.setParameter("value", value);

        List<?> results = query.getResultList();

        Assert.isTrue(
                results.size() <= 1,
                String.format("%s deve ser único", cls.getName())
        );

        return results.isEmpty();
    }

    @Override
    public void initialize(Singular params) {
        domain = params.fieldName();
        cls = params.domainClass();
    }
}
