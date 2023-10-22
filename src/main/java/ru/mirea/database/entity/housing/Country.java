package ru.mirea.database.entity.housing;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Country {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotNull
    @ManyToOne
    private Region region;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Country(String name, Region region) {
        this.name = name;
        this.region = region;
    }

}
