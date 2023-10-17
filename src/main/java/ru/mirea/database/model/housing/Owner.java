package ru.mirea.database.model.housing;

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
public class Owner {                                        // TODO: 17.10.2023 Add phone and email validation

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;

    @NotBlank
    @Size(max = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Owner(String name, String phoneNumber, String email, Owner owner) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.owner = owner;
    }
}
