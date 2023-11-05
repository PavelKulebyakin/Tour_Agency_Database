package ru.mirea.database.data.repository.housing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.dto.HousingDTO;
import ru.mirea.database.data.entity.housing.Housing;

public interface CustomSearchRepository {

    Page<HousingDTO> findNameAndAddressBy(Specification<Housing> specification, Pageable pageable);
}
