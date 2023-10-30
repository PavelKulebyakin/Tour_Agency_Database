package ru.mirea.database.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.data.repository.housing.HousingRepository;
import ru.mirea.database.service.HousingSearchService;
import ru.mirea.database.util.HousingSpecificationBuilder;
import ru.mirea.database.util.SearchCriteria;

import java.util.List;

@Service
public class HousingSearchServiceImpl implements HousingSearchService {

    private final HousingRepository repository;

    private final Logger logger = LoggerFactory.getLogger(HousingSearchServiceImpl.class);

    @Autowired
    public HousingSearchServiceImpl(HousingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Housing> search(HousingSearchDTO housingSearchDTO, Pageable pageable) {

        HousingSpecificationBuilder builder = new HousingSpecificationBuilder();
        List<SearchCriteria> criteriaList = housingSearchDTO.getSearchCriteriaList();

        if (criteriaList != null) criteriaList.forEach(builder::with);

        logger.info(repository.findAll(builder.build()).toString());

        Page<Housing> page = repository.findAll(builder.build(), pageable);
        return page;
    }
}
