package ru.mirea.database.data.dto.property;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.database.annotation.Unique;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    protected Long id;
    protected String name;
    protected String address;
    protected int numberOfRooms;
    protected int capacity;
    protected TypeOfFood typeOfFood;
    protected City city;
    protected Owner owner;
    protected PropertyType propertyType;

}
