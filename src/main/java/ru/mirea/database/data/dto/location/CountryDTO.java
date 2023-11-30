package ru.mirea.database.data.dto.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.location.Region;

@Data
@AllArgsConstructor
public class CountryDTO {

    protected String name;
    protected Region region;

}
