package ru.mirea.database.data.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportDTO {

    protected String name;
    protected int identificator;
    protected String address;

}
