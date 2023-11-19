package ru.mirea.database.data.entity.tickets;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "ticket")
public class Ticket  {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @Setter(value = PRIVATE)
    protected Long id;

    @NotNull
    @Column(name = "flight_number")
    protected int flightNumber;

    @NotNull
    @Column(name = "departure_time")
    protected Date departureDate;

    @NotNull
    @Column(name = "arrival_time")
    protected Date arrivalDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airline_id")
    protected Airline airline;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airport_id")
    protected Airport airport;

}
