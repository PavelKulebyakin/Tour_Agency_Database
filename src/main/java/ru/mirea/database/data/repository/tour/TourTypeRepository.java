package ru.mirea.database.data.repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tour.TourType;

public interface TourTypeRepository
        extends JpaRepository<TourType, Long> {
}
