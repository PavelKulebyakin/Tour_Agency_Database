package ru.mirea.database.data.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)                          // TODO: 19.11.2023 check 
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    protected Long id;

    protected String name;

//    @Setter(value = AccessLevel.PROTECTED)
//    @ManyToMany(mappedBy = "role")
//    protected Set<UserEntity> user = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

}
