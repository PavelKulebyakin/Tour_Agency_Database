package ru.mirea.database.data.repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.tour.Tour;

public interface JpaTourRepository
        extends JpaRepository<Tour, Long> {
}
