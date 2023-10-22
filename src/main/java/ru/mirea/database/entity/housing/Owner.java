package ru.mirea.database.entity.housing;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Owner {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;             // TODO: 17.10.2023 Add phone validation

    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @ManyToOne
    private OwnerType ownerType;

    public Owner(String name, String phoneNumber, String email, OwnerType ownerType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ownerType = ownerType;
    }

}
