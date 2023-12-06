package ru.mirea.database.service.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.search.SearchCriteriaDTO;
import ru.mirea.database.data.entity.property.Property;


public interface PropertySearchService {
    Page<Property> search(SearchCriteriaDTO propertySearchCriteria, Pageable pageable);

//    Page<Housing> searchByCountry(String countryName, HousingSearchDTO housingSearchDTO, Pageable pageable);

}
