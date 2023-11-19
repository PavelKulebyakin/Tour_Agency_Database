package ru.mirea.database.data.entity.tour;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.tickets.Ticket;

import java.sql.Date;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @Setter(value = PRIVATE)
    protected Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "name")
    protected String name;

    @NotNull
    @Column(name = "price")
    protected int price;

    @NotNull
    @Column(name = "start_date")
    protected Date startDate;

    @NotNull
    @Column(name = "end_date")
    protected Date endDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tour_type_id")
    protected TourType tourType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "property_id")
    protected Property property;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tour_company_id")
    protected TourCompany tourCompany;
    
    @NotNull
    @ManyToMany
    @JoinTable(name = "tour_ticket",
            joinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "id"))
    protected Set<Ticket> tickets;

}
