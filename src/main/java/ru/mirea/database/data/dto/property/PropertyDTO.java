package ru.mirea.database.data.dto.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;

@Data
@AllArgsConstructor
public class PropertyDTO {

    protected String name;
    protected String address;
    protected int numberOfRooms;
    protected int capacity;
    protected City city;
    protected TypeOfFood typeOfFood;
    protected Owner owner;
    protected PropertyType propertyType;

}
