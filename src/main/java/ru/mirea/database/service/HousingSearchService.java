package ru.mirea.database.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.HousingDTO;
import ru.mirea.database.data.dto.HousingSearchDTO;


public interface HousingSearchService {
    Page<HousingDTO> search(HousingSearchDTO housingSearchDTO, Pageable pageable);

//    Page<Housing> searchByCountry(String countryName, HousingSearchDTO housingSearchDTO, Pageable pageable);

}
