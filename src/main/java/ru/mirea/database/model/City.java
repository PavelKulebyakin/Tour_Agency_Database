package ru.mirea.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class City {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
