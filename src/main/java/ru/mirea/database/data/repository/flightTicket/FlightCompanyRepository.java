package ru.mirea.database.data.repository.flightTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.database.data.entity.flightTicket.FlightCompany;

public interface FlightCompanyRepository
    extends JpaRepository<FlightCompany, Long> {
}
