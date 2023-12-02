package ru.mirea.database.data.entity.property;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Owner {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    @Size(max = 20)
    protected String name;

    @NotBlank
    @Size(max = 20)
    protected String phoneNumber;             // TODO: 17.10.2023 Add phone validation

    @Email
    @Size(max = 100)
    protected String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    protected OwnerType ownerType;

    public Owner(String name, String phoneNumber, String email, OwnerType ownerType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ownerType = ownerType;
    }

}
