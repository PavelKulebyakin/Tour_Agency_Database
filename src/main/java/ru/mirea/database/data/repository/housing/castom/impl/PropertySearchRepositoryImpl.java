package ru.mirea.database.data.repository.housing.castom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.repository.housing.castom.PropertySearchRepository;

@Repository
public class PropertySearchRepositoryImpl implements PropertySearchRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Page<Property> findNameAndAddressBy(Specification<Property> specification, Pageable pageable) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = criteriaBuilder.createQuery(Property.class);
        Root<Property> housing = criteriaQuery.from(Property.class);

        criteriaQuery.select(criteriaBuilder.construct(Property.class, housing.get("name"), housing.get("address")))
                .where(specification.toPredicate(housing, criteriaQuery, criteriaBuilder));

        TypedQuery<Property> pageableQuery = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize());

        return new PageImpl<>(pageableQuery.getResultList());
    }
}
