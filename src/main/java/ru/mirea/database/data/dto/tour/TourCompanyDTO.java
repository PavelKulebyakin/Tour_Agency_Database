package ru.mirea.database.data.dto.tour;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TourCompanyDTO {

    protected String name;
    protected String phoneNumber;
    protected String email;

}
