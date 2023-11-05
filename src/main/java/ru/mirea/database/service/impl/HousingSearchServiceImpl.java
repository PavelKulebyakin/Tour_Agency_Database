package ru.mirea.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.HousingDTO;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.data.repository.housing.CustomSearchRepository;
import ru.mirea.database.service.HousingSearchService;
import ru.mirea.database.service.util.CustomSpecificationBuilder;

@Service
public class HousingSearchServiceImpl implements HousingSearchService {

    private final CustomSearchRepository repository;

    private final CustomSpecificationBuilder<Housing> specificationBuilder;

    @Autowired
    public HousingSearchServiceImpl(CustomSearchRepository repository, CustomSpecificationBuilder<Housing> specificationBuilder) {
        this.repository = repository;
        this.specificationBuilder = specificationBuilder;
    }

    @Override
    public Page<HousingDTO> search(HousingSearchDTO housingSearchDTO, Pageable pageable) {     // TODO: 04.11.2023 add null check
        specificationBuilder.with(housingSearchDTO.getSearchCriteriaList());
        return repository.findNameAndAddressBy(specificationBuilder.build(), pageable);
    }

}
