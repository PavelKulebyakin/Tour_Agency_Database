package ru.mirea.database.util.search;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class GenericSearchSpecification<T> implements Specification<T> {

    protected final SearchCriteria criteria;

    public GenericSearchSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        SearchOperation operation = SearchOperation.valueOf(criteria.getOperation().toUpperCase());

        Path<T> path = root.get(criteria.getFilterKey());
        Object value = criteria.getValue();

        return switch (operation) {
            case EQUAL -> builder.equal(path, value);
            case NOT_EQUAL -> builder.notEqual(path, value);
            default -> builder.conjunction();
        };

    }

}
