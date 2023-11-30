package ru.mirea.database.service.data.tour.impl;

import ru.mirea.database.data.entity.tour.TourCompany;
import ru.mirea.database.data.repository.tour.JpaTourCompanyRepository;
import ru.mirea.database.service.data.tour.TourCompanyService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TourCompanyServiceImplementation implements TourCompanyService {
    protected JpaTourCompanyRepository tourCompanyRepository;

    public TourCompanyServiceImplementation(JpaTourCompanyRepository tourCompanyRepository) {
        this.tourCompanyRepository = tourCompanyRepository;
    }

    @Override
    public TourCompany save(TourCompany tourCompany) {
        return tourCompanyRepository.save(tourCompany);
    }

    @Override
    public List<TourCompany> allCompanies() {
        return tourCompanyRepository.findAll();
    }

    @Override
    public Optional<TourCompany> getCompanyById(Long id) throws NoSuchElementException {
        Optional<TourCompany> tourCompany = tourCompanyRepository.findById(id);
        if(tourCompany.isPresent()) {
            return tourCompany;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteCompanyById(Long id) {
        tourCompanyRepository.deleteById(id);
    }
}
