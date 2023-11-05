package ru.mirea.database.service.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.mirea.database.data.entity.housing.Housing;

import java.util.ArrayList;
import java.util.List;

@Component
public class HousingSpecificationBuilder {

    private final List<SearchCriteria> params;
    private final EntityManager entityManager;

    public HousingSpecificationBuilder(EntityManager entityManager) {
        this.params = new ArrayList<>();
        this.entityManager = entityManager;
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

        if (params.isEmpty()) return null;                                                                              // TODO: 04.11.2023 add default

        Specification<Housing> result = new HousingSpecification(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            SearchCriteria criteria = params.get(i);
            result = criteria.isOrPredicate()
                    ? Specification.where(result).or(new HousingSpecification(criteria))
                    : Specification.where(result).and(new HousingSpecification(criteria));
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        return result;
    }



}
