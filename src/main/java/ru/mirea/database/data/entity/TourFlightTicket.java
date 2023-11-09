package ru.mirea.database.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.database.data.entity.flightTicket.FlightTicket;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TourFlightTicket {

    @NotNull
    @ManyToOne
    private FlightTicket flightTicket;

    /*@NotNull
    @ManyToOne
    private Tour tour;*/

    public TourFlightTicket(FlightTicket flightTicket /*, Tout tour*/) {
        this.flightTicket = flightTicket;
        //this.tour = tour;
    }
}
