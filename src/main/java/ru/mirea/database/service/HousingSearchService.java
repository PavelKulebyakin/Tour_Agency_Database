package ru.mirea.database.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;


public interface HousingSearchService {
    Page<Housing> search(HousingSearchDTO housingSearchDTO, Pageable pageable);

    Page<Housing> searchByCountry(String countryName, HousingSearchDTO housingSearchDTO, Pageable pageable);
}
