package ru.mirea.database.service.util;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class CustomSpecification<T> implements Specification<T> {

    private final SearchCriteria criteria;

    public CustomSpecification(SearchCriteria criteria) {
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
