package ru.mirea.database.data.entity.property;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class OwnerType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    @Size(max = 20)
    protected String name;

    public OwnerType(String name) {
        this.name = name;
    }

}
