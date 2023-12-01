package ru.mirea.database.data.dto.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyInputDTO {

    protected Long id;
    protected String name;
    protected String address;
    protected int numberOfRooms;
    protected int capacity;
    protected Long cityId;
    protected Long typeOfFoodId;
    protected Long ownerId;
    protected Long propertyTypeId;

}
