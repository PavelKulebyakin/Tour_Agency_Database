package ru.mirea.database.data.repository.housing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.mirea.database.data.entity.housing.Housing;

public interface JpaHousingRepository
        extends JpaRepository<Housing, Long>, JpaSpecificationExecutor<Housing> {
}
