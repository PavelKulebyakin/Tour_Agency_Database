package ru.mirea.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.data.repository.housing.HousingRepository;
import ru.mirea.database.service.util.HousingSpecification;
import ru.mirea.database.service.util.SearchCriteria;

import java.util.List;

@SpringBootTest
class DatabaseApplicationTests {

    @Autowired
    HousingRepository repository;

    @Test
    void contextLoads() {
    }

}
