package ru.mirea.database.data.entity.tickets;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Airline {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    @Size(max = 20)
    protected String name;

    public Airline(String name) {
        this.name = name;
    }
}
