package ru.mirea.database.controller.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.database.data.dto.location.RegionDTO;
import ru.mirea.database.service.data.location.RegionService;

import java.util.List;

@RestController
@RequestMapping("api/region")
public class RestRegionController {

    protected final RegionService regionService;

    public RestRegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("")
    public List<RegionDTO> findAll(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<RegionDTO> page = regionService.findAll(pageable);
        List<RegionDTO> regions = page.getContent();
        return regions;
    }
}
