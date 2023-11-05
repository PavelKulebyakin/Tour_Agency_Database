package ru.mirea.database.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;

public interface QdslCustomSearchService {

    Page<Housing> search(HousingSearchDTO searchDTO, Pageable pageable);

}
