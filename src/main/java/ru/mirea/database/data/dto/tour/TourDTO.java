package ru.mirea.database.data.dto.tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.tour.TourCompany;
import ru.mirea.database.data.entity.tour.TourType;

import java.sql.Date;

@Data
@AllArgsConstructor
public class TourDTO {

    protected String name;
    protected int price;
    protected Date startDate;
    protected Date endDate;
    protected TourType type;
    protected Property property;
    protected TourCompany company;

}
