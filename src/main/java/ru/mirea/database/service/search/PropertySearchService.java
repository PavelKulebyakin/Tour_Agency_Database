package ru.mirea.database.service.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.property.PropertyOutputDTO;
import ru.mirea.database.data.dto.search.SearchCriteriaDTO;


public interface PropertySearchService {
    Page<PropertyOutputDTO> search(SearchCriteriaDTO propertySearchCriteria, Pageable pageable);

//    Page<Housing> searchByCountry(String countryName, HousingSearchDTO housingSearchDTO, Pageable pageable);

}
