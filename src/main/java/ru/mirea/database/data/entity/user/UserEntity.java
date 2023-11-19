package ru.mirea.database.data.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor(access = PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    protected String username;
    @NotBlank
    protected String password;
//    @NotBlank
    protected String firstname;
//    @NotBlank
    protected String lastname;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    protected Set<Role> role = new HashSet<>();

    public void addRole(Role newRole) {
        this.role.add(newRole);
    }

    @Builder
    public UserEntity(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
