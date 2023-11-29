package ru.mirea.database.service.data.tour;

import ru.mirea.database.data.entity.tour.TourCompany;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface TourCompanyService {
    TourCompany save(TourCompany tourCompany);

    List<TourCompany> allCompanies();

    Optional<TourCompany> getCompanyById(Long id) throws NoSuchElementException;

    void deleteCompanyById(Long id);
}
