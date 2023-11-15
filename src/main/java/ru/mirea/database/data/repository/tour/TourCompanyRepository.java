package ru.mirea.database.data.repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tour.TourCompany;

public interface TourCompanyRepository
        extends JpaRepository<TourCompany, Long> {
}
