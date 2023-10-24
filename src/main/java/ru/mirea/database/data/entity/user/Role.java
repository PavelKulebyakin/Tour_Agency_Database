package ru.mirea.database.data.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

//    @Setter(value = AccessLevel.PRIVATE)
//    @ManyToMany(mappedBy = "role")
//    private Set<UserEntity> user = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

}
