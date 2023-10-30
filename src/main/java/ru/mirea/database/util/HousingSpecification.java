package ru.mirea.database.util;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.entity.housing.Housing;

public class HousingSpecification implements Specification<Housing> {

    public enum SearchOperation {
        EQUAL, NOT_EQUAL, GREATER_THEN, LESS_THEN,
        LIKE, STARTS_WITH, ENDS_WITH, CONTAINS
    }

    private final SearchCriteria criteria;

    public HousingSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Housing> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        SearchOperation operation = SearchOperation.valueOf(criteria.getOperation());             // TODO: 29.10.2023 add check

        Path<Object> path = root.get(criteria.getFilterKey());
        Object value = criteria.getValue();

        switch (operation) {

            case EQUAL -> {
                return builder.equal(path.as(String.class), value);
            }

            case NOT_EQUAL -> builder.notEqual(path, value);

            case GREATER_THEN -> {
                if (path.getJavaType().isAssignableFrom(int.class)) {
                    return builder.greaterThan(path.as(int.class), (int) value);
                }
            }
            case LESS_THEN -> {
                if (path.getJavaType().isAssignableFrom(int.class)) {
                    return builder.lessThan(path.as(int.class), (int) value);
                }
            }

            case LIKE -> builder
                    .like(path.as(String.class), value.toString());
            case STARTS_WITH -> builder
                    .like(path.as(String.class), value + "%");
            case ENDS_WITH -> builder
                    .like(path.as(String.class), "%" + value);
            case CONTAINS -> builder
                    .like(path.as(String.class), "%" + value + "%");

        }

        throw new IllegalArgumentException("%s cannot be applied to an object of type %s"
                .formatted(operation.name(), path.getJavaType()));
    }
}
