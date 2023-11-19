package ru.mirea.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyRepository;

@SpringBootTest
class DatabaseApplicationTests {

    @Autowired
    JpaPropertyRepository repository;

    @Test
    void contextLoads() {
    }

}
