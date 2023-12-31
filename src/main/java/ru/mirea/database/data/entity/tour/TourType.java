package ru.mirea.database.data.entity.tour;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TourType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    protected Long id;

    @NotBlank
    @Size(max = 20)
    protected String typeName;

    public TourType(String typeName) {
        this.typeName = typeName;
    }
}
