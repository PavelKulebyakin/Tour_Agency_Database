package ru.mirea.database.service.data.location.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mirea.database.data.dto.location.RegionDTO;
import ru.mirea.database.data.repository.location.JpaRegionRepository;
import ru.mirea.database.service.data.location.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

    private final JpaRegionRepository regionRepository;

    public RegionServiceImpl(JpaRegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Page<RegionDTO> findAll(Pageable pageable){
        return regionRepository.findAllBy(pageable);
    }
}
