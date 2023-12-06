package ru.mirea.database.data.entity.property;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.database.annotation.Unique;
import ru.mirea.database.data.entity.location.City;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
//    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    @Column(name = "name")
    protected String name;

    @NotBlank
    @Size(max = 100)
    @Column(name = "address")
    protected String address;

    @NotNull
    @Column(name = "number_of_rooms")
    protected int numberOfRooms;

    @NotNull
    @Column(name = "capacity")
    protected int capacity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_food_id")
    protected TypeOfFood typeOfFood;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    protected City city;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    protected Owner owner;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_type_id")
    protected PropertyType propertyType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})                          // TODO: 19.11.2023 check cascade type
    @JoinTable(name = "property_facilities",
            joinColumns = @JoinColumn(name = "property_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facilities_id", referencedColumnName = "id"))
    protected Set<Facilities> facilities = new HashSet<>();

    public Property(String name, String address, int numberOfRooms, int capacity, TypeOfFood typeOfFood, City city, Owner owner, PropertyType propertyType) {
        this.name = name;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.capacity = capacity;
        this.typeOfFood = typeOfFood;
        this.city = city;
        this.owner = owner;
        this.propertyType = propertyType;
    }
}
