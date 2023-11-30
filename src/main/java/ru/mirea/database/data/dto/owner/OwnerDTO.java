package ru.mirea.database.data.dto.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.property.OwnerType;

@Data
@AllArgsConstructor
public class OwnerDTO {

    protected OwnerType type;
    protected String name;
    protected String phoneNumber;
    protected String email;

}
