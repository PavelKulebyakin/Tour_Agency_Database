package ru.mirea.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.data.repository.housing.HousingRepository;
import ru.mirea.database.service.HousingSearchService;
import ru.mirea.database.util.HousingSpecificationBuilder;
import ru.mirea.database.util.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class HousingSearchServiceImpl implements HousingSearchService {

    private final HousingRepository repository;
    private final HousingSpecificationBuilder specificationBuilder;

    @Autowired
    public HousingSearchServiceImpl(HousingRepository repository, HousingSpecificationBuilder specificationBuilder) {
        this.repository = repository;
        this.specificationBuilder = specificationBuilder;
    }

    @Override
    public Page<Housing> search(HousingSearchDTO housingSearchDTO, Pageable pageable) {
        List<SearchCriteria> criteriaList = housingSearchDTO.getSearchCriteriaList();
        if (!criteriaList.isEmpty()) {
            criteriaList.forEach(specificationBuilder::with);
        }
        return repository.findAll(specificationBuilder.build(), pageable);
    }

    @Override
    public Page<Housing> searchByCountry(String countryName, HousingSearchDTO housingSearchDTO, Pageable pageable) {
        List<SearchCriteria> criteriaList = housingSearchDTO.getSearchCriteriaList();
        if (!criteriaList.isEmpty()) {
            criteriaList.forEach(specificationBuilder::with);
        }
        return repository.findAllByCountry(specificationBuilder.build().and(fromCountry(countryName)), pageable);
    }

    private static Specification<Housing> fromCity(String countryName) {
        return (root, query, builder) -> builder
                .equal(root.get("city").get("name"), countryName);
    }

    private static Specification<Housing> fromCountry(String countryName) {
        return (root, query, builder) -> builder
                .equal(root.join("city").get("country").get("name"), countryName);
    }

    
}
