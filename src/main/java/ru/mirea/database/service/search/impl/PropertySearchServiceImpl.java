package ru.mirea.database.service.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.dto.search.SearchCriteriaDTO;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.repository.housing.castom.PropertySearchRepository;
import ru.mirea.database.service.search.PropertySearchService;
import ru.mirea.database.util.search.GenericSearchSpecificationBuilder;

@Service
public class PropertySearchServiceImpl implements PropertySearchService {

    protected final PropertySearchRepository repository;

    protected final GenericSearchSpecificationBuilder<Property> specificationBuilder;

    @Autowired
    public PropertySearchServiceImpl(PropertySearchRepository repository, GenericSearchSpecificationBuilder<Property> specificationBuilder) {
        this.repository = repository;
        this.specificationBuilder = specificationBuilder;
    }

    @Override
    public Page<PropertyDTO> search(SearchCriteriaDTO propertySearchCriteria, Pageable pageable) {
        specificationBuilder.with(propertySearchCriteria.getSearchCriteriaList());
        return repository.findNameAndAddressBy(specificationBuilder.build(), pageable);
    }

}
