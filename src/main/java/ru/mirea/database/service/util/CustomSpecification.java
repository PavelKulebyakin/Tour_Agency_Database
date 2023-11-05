package ru.mirea.database.service.util;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class CustomSpecification<T> implements Specification<T> {

    public enum SearchOperation {
        EQUAL, NOT_EQUAL, GREATER_THEN, LESS_THEN,
        LIKE, STARTS_WITH, ENDS_WITH, CONTAINS
    }

    private final SearchCriteria criteria;

    public CustomSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        SearchOperation operation = SearchOperation.valueOf(criteria.getOperation().toUpperCase());

        Path<T> path = root.get(criteria.getFilterKey());

        switch (operation) {
            case EQUAL -> builder.equal(root.get(criteria.getFilterKey()), criteria.getValue());
            case NOT_EQUAL -> builder.notEqual(root.get(criteria.getFilterKey()), criteria.getValue());
        }

        return builder.conjunction();       //TODO
    }

}
