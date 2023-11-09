package ru.mirea.database.data.entity.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "booking")
public class Booking {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;*/

    @NotNull
    @ManyToOne
    @JoinColumn(name = "booking_status")
    private BookingStatus booingStatus;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "booking_date")
    private Date bookingDate;

}
