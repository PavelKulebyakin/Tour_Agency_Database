package ru.mirea.database.data.entity.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    protected Long id;

    @NotNull
    @OneToOne
    protected Booking booking;

    @NotNull
    protected int rating;

    @NotBlank
    @Size(max = 500)
    protected String text;

    @NotNull
    @CreatedDate
    protected LocalDate date;

    public Review(Booking booking, int rating, String text) {
        this.booking = booking;
        this.rating = rating;
        this.text = text;
    }
}
