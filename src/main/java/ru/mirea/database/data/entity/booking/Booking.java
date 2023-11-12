package ru.mirea.database.data.entity.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;                                   // TODO: 12.11.2023 check Date package

import static lombok.AccessLevel.PROTECTED;

//
@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "booking")
public class Booking {
                                                        // TODO: 12.11.2023 add composite primary key (id)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    /*@NotNull
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;*/

    @NotNull
    @OneToOne
    @JoinColumn(name = "booking_status_id")
    private BookingStatus booingStatus;

    @NotNull
    @Setter(value = PROTECTED)                          // TODO: 12.11.2023 add immutable
    private Date bookingDate;                           // TODO: 12.11.2023 add generator

}
