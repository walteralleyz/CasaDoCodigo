package br.com.zup.desafio.CasaDoCodigo.validation;

import br.com.zup.desafio.CasaDoCodigo.annotation.Exists;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidationExists implements ConstraintValidator<Exists, Object> {
    private String attr;
    private Class<?> cls;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(Exists params) {
        attr = params.fieldName();
        cls = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(
                String.format("select 1 from %s where %s = :value", cls.getName(), attr)
        );

        query.setParameter("value", value);

        List<?> results = query.getResultList();

        return Integer.parseInt(value.toString()) == 0 || !results.isEmpty();
    }
}
