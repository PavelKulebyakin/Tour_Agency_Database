package ru.mirea.database.data.repository.housing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.mirea.database.data.entity.housing.Housing;

public interface HousingRepository
        extends JpaRepository<Housing, Long>, JpaSpecificationExecutor<Housing> {

    @Query("SELECT h.name, h.numberOfRooms, h.addres, h.city.name, h.typeOfFood.name FROM Housing as h")
    Page<Housing> findAll(Specification<Housing> specification, Pageable pageable);

    @Query("SELECT h.name, h.addres, h.city.name, h.city.country.name FROM Housing as h")
    Page<Housing> findAllByCountry(Specification<Housing> specification, Pageable pageable);

}
