package ru.mirea.database.data.dto.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.location.Country;

@Data
@AllArgsConstructor
public class CityDTO {

    protected String name;
    protected Country country;

}
