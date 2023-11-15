package ru.mirea.database.data.entity.flightTicket;

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
public class Airport {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String identificator;

    @NotBlank
    @Size(max = 100)
    private String addres;

    public Airport(String name, String identificator, String addres) {
        this.name = name;
        this.identificator = identificator;
        this.addres = addres;
    }
}
