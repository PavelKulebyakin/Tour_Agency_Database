package ru.mirea.database.data.entity.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import ru.mirea.database.data.entity.tour.Tour;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

//
@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    protected Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    protected Client client;

    @NotNull
    @OneToOne
    @JoinColumn(name = "tour_id")
    protected Tour tour;

    @NotNull
    @OneToOne
    @JoinColumn(name = "booking_status_id")
    protected BookingStatus booingStatus;

    @NotNull
    @CreatedDate
    @Column(name = "date")
    protected LocalDate bookingDate;

}
