package ru.mirea.database.data.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.database.data.entity.booking.Booking;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    protected Long id;
    protected Booking booking;
    protected int rating;
    protected String text;
    protected Date date;
}
