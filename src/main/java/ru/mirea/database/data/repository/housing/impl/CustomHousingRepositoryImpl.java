package ru.mirea.database.data.repository.housing.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.data.repository.housing.CustomHousingRepository;

public class CustomHousingRepositoryImpl implements CustomHousingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Housing> findNameAndAddresBy(Specification<Housing> specification, Pageable pageable) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Housing> query = builder.createQuery(Housing.class);
        Root<Housing> root = query.from(Housing.class);

        query.multiselect(root.get("name"), root.get("address"))
             .where(specification.toPredicate(root, query, builder));

        return  null; //TODO
    }
}
