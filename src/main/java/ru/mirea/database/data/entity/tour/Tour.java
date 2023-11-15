package ru.mirea.database.data.entity.tour;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mirea.database.data.entity.housing.Housing;

import java.sql.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Data
@Entity
@NoArgsConstructor(access = PROTECTED)
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "price")
    private int price;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tour_type_id")
    private TourType tourType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "housing_id")
    private Housing housing;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tour_company_id")
    private TourCompany tourCompany;

}
