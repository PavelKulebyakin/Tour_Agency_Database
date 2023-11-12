package ru.mirea.database.data.entity.booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

                                                                // TODO: 12.11.2023 add composite primary key (id)
    @NotNull
    @ManyToOne
    private Client client;

    /*@NotNull
    @ManyToOne
    private Tour tour;*/

    @NotNull
    private int rating;

    @NotBlank
    @Size(max = 500)
    private String text;                                        // TODO: 12.11.2023 check SLOB

    @NotNull
    private Date date;

    public Review(Client client, /*Tour tour,*/ int rating, String text, Date date) {
        this.client = client;
        //this.tour = tour;
        this.rating = rating;
        this.text = text;
        this.date = date;
    }
}
