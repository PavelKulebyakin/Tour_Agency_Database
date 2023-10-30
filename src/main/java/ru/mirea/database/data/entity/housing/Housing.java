package ru.mirea.database.data.entity.housing;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "housing")
public class Housing {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 100)
    @Column(name = "addres")
    private String addres;

    @NotNull
    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_of_food_id")
    private TypeOfFood typeOfFood;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "housing_type_id")
    private HousingType housingType;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "housing_amenities",
            joinColumns = @JoinColumn(name = "housing_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "amenities_id", referencedColumnName = "id"))
    private Set<Amenities> amenities = new HashSet<>();

}
