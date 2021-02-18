package br.com.zup.desafio.CasaDoCodigo.validation;

import br.com.zup.desafio.CasaDoCodigo.interfaces.UniqueState;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidationUniqueState implements ConstraintValidator<UniqueState, Object> {
    private String attr;
    private Class<?> cls;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueState params) {
        attr = params.fieldName();
        cls = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(String.format(
            "select stt from %s stt where stt.%s = :v and stt.country.id = :c",
            cls.getName(), attr
        ));

        String v = value.toString().split(":")[0];
        String c = value.toString().split(":")[1];

        query.setParameter("v", v);
        query.setParameter("c", Integer.parseInt(c));

        List<?> results = query.getResultList();

        Assert.isTrue(
            results.size() <= 1,
            String.format("%s state name deve ser único", cls.getName())
        );

        return results.isEmpty();
    }
}
