package ru.mirea.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.database.data.repository.housing.JpaHousingRepository;

@SpringBootTest
class DatabaseApplicationTests {

    @Autowired
    JpaHousingRepository repository;

    @Test
    void contextLoads() {
    }

}
