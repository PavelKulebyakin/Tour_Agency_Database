package ru.mirea.database.data.entity.flightTicket;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

// TODO: 12.11.2023 add relationship

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "flight_ticket")
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "flight_number")
    private int flightNumber;

    @NotNull
    @Column(name = "departure_time")
    private Date departureDate;

    @NotNull
    @Column(name = "arrival_time")
    private Date arrivalDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "flight_company_id")
    private FlightCompany flightCompany;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

}
