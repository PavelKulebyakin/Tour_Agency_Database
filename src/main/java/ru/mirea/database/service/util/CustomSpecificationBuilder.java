package ru.mirea.database.service.util;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSpecificationBuilder<T> {

    private final List<SearchCriteria> criteria;

    public CustomSpecificationBuilder() {
        this.criteria = new ArrayList<>();
    }

    public final CustomSpecificationBuilder<T> with(String key, String operation, Object value) {
        criteria.add(SearchCriteria.from(key, operation, value));
        return this;
    }

    public final CustomSpecificationBuilder<T> with(String key, String operation, Object value, Boolean orPredicate) {
        criteria.add(SearchCriteria.from(key, operation, value, orPredicate));
        return this;
    }

    public final CustomSpecificationBuilder<T> with(SearchCriteria searchCriteria) {
        criteria.add(searchCriteria);
        return this;
    }

    public Specification<T> build() {

        if (criteria.isEmpty())
            return ((root, query, builder) -> builder.conjunction());                                                                              // TODO: 04.11.2023 add default

        Specification<T> result = new CustomSpecification<>(criteria.get(0));
        for (int i = 1; i < criteria.size(); i++) {
            SearchCriteria criteria = this.criteria.get(i);
            result = criteria.isOrPredicate() ?
                    Specification.where(result).or(new CustomSpecification<>(criteria)) :
                    Specification.where(result).and(new CustomSpecification<>(criteria));
        }

        return result;
    }


}
