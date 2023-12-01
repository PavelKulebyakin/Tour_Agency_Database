package ru.mirea.database.data.dto.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyOutputDTO {

    protected Long id;
    protected String name;
    protected String address;
    protected int numberOfRooms;
    protected int capacity;
    protected String city;
    protected String typeOfFood;
    protected String owner;
    protected String propertyType;

}
