package ru.mirea.database.util;

import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.entity.housing.Housing;

import java.util.ArrayList;
import java.util.List;

public class HousingSpecificationBuilder {

    private final List<SearchCriteria> params;

    public HousingSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final HousingSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value, false));
        return this;
    }

    public final HousingSpecificationBuilder with(String key, String operation, Object value, Boolean orPredicate) {
        params.add(new SearchCriteria(key, operation, value, orPredicate));
        return this;
    }

    public final HousingSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Housing> build() {

        if (params.isEmpty()) return null;

        Specification<Housing> result = new HousingSpecification(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            SearchCriteria criteria = params.get(i);
            result = criteria.isOrPredicate()
                    ? Specification.where(result).or(new HousingSpecification(criteria))
                    : Specification.where(result).and(new HousingSpecification(criteria));
        }

        return result;
    }

}
