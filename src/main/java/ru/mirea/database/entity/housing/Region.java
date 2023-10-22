package ru.mirea.database.entity.housing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Region {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @OneToMany(mappedBy = "region")
    private Set<Country> countries;

    public Region(String name) {
        this.name = name;
    }

}
