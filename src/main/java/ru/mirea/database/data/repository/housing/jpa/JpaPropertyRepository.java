package ru.mirea.database.data.repository.housing.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.mirea.database.data.dto.property.PropertyInputDTO;
import ru.mirea.database.data.dto.property.PropertyOutputDTO;
import ru.mirea.database.data.entity.property.Property;

public interface JpaPropertyRepository
        extends JpaRepository<Property, Long>, PagingAndSortingRepository<Property, Long>{

    @Query("SELECT new ru.mirea.database.data.dto.property.PropertyOutputDTO(p.id, p.name, p.address, p.numberOfRooms, " +
            "p.capacity, p.city.name, p.typeOfFood.name, p.owner.name, p.propertyType.name) from Property as p ")
    Page<PropertyOutputDTO> findAllAsDTO(Pageable pageable);

//    @Modifying
//    @Query(nativeQuery = true, value = "INSERT INTO Property(name, address, number_of_rooms, capacity, type_of_food_it, city_id, owner_id, property_type_id")
//    void save(PropertyInputDTO inputDTO);


}
