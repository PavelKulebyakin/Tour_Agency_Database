package ru.mirea.database.util.search;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class GenericSearchSpecificationBuilder<T> {

    protected final List<SearchCriteria> criteria;

    public GenericSearchSpecificationBuilder() {
        this.criteria = new ArrayList<>();
    }

    public final GenericSearchSpecificationBuilder<T> with(String key, String operation, Object value) {
        criteria.add(SearchCriteria.from(key, operation, value));
        return this;
    }

    public final GenericSearchSpecificationBuilder<T> with(String key, String operation, Object value, Boolean orPredicate) {
        criteria.add(SearchCriteria.from(key, operation, value, orPredicate));
        return this;
    }

    public final GenericSearchSpecificationBuilder<T> with(SearchCriteria searchCriteria) {
        criteria.add(searchCriteria);
        return this;
    }

    public final GenericSearchSpecificationBuilder<T> with(Collection<? extends SearchCriteria> searchCriteriaList) {
        criteria.addAll(searchCriteriaList);
        return this;
    }

    public Specification<T> build() {

        if (criteria.isEmpty()) return ((root, query, builder) -> builder.conjunction());                                             

        Specification<T> result = new GenericSearchSpecification<>(criteria.get(0));
        for (int i = 1; i < criteria.size(); i++) {
            SearchCriteria criteria = this.criteria.get(i);
            result = criteria.isOrPredicate() ?
                    Specification.where(result).or(new GenericSearchSpecification<>(criteria)) :
                    Specification.where(result).and(new GenericSearchSpecification<>(criteria));
        }

        criteria.clear();
        return result;
    }


}
