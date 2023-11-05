package ru.mirea.database.data.repository.housing;

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
import ru.mirea.database.data.dto.HousingDTO;
import ru.mirea.database.data.entity.housing.Housing;

@Repository
public class CustomSearchRepositoryImpl implements CustomSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<HousingDTO> findNameAndAddressBy(Specification<Housing> specification, Pageable pageable) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HousingDTO> criteriaQuery = criteriaBuilder.createQuery(HousingDTO.class);
        Root<Housing> housingRoot = criteriaQuery.from(Housing.class);

        criteriaQuery.select(criteriaBuilder.construct(HousingDTO.class, housingRoot.get("name"), housingRoot.get("addres")))
                .where(specification.toPredicate(housingRoot, criteriaQuery, criteriaBuilder));

        TypedQuery<HousingDTO> pageableQuery = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize());

        return new PageImpl<>(pageableQuery.getResultList());
    }
}
