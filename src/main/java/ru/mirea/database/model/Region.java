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
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "region_name")
    private String name;

//    @OneToMany(mappedBy = "region")
//    private List<Country> countries;

    public Region(String name) {
        this.name = name;
    }

}
