package ru.mirea.database.data.repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tour.TourCompany;

public interface JpaTourCompanyRepository
        extends JpaRepository<TourCompany, Long> {
}
