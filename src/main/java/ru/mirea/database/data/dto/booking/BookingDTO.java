package ru.mirea.database.data.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.database.data.entity.booking.BookingStatus;
import ru.mirea.database.data.entity.booking.Client;
import ru.mirea.database.data.entity.tour.Tour;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    protected Long id;
    protected Tour tour;
    protected BookingStatus bookingStatus;
    protected Date date;
    protected Client client;

}
