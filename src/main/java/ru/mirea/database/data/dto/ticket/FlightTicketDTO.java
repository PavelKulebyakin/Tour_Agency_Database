package ru.mirea.database.data.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mirea.database.data.entity.tickets.Airport;

import java.sql.Date;

@Data
@AllArgsConstructor
public class FlightTicketDTO {

    protected int flightNumber;
    protected Date departureTime;
    protected Date arrivalTime;
    //protected FlightCompany flightCompany;
    protected Airport airport;

}
