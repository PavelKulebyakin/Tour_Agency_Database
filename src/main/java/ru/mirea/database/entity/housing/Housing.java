package ru.mirea.database.entity.housing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Housing {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String addres;

    @NotNull
    private int numberOfRooms;

    @NotNull
    private int capacity;

    @NotNull
    @ManyToOne
    private TypeOfFood typeOfFood;

    @NotNull
    @ManyToOne
    private City city;

    @NotNull
    @ManyToOne
    private Owner owner;

    @NotNull
    @ManyToOne
    private HousingType housingType;

    @ManyToMany
    private Set<Amenities> amenities;

}
