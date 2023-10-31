package ru.mirea.database.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.HousingSearchDTO;
import ru.mirea.database.data.entity.housing.Housing;
import ru.mirea.database.service.HousingSearchService;

import java.util.List;

@RestController
@RequestMapping("api/search")
public class SearchController {

    private final HousingSearchService housingSearchService;

    public SearchController(HousingSearchService housingSearchService) {
        this.housingSearchService = housingSearchService;
    }

    @PostMapping("housing/{PAGE_NUM}/{PAGE_SIZE}")
    public ResponseEntity<List<Housing>> searchHousing(@PathVariable("PAGE_NUM") int pageNumber,
                                                       @PathVariable("PAGE_SIZE") int pageSize,
                                                       @RequestBody HousingSearchDTO housingSearchDTO) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Housing> page = housingSearchService.search(housingSearchDTO, pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @PostMapping("housing/by_country/{COUNTRY_NAME}/{PAGE_NUM}/{PAGE_SIZE}")
    public ResponseEntity<List<Housing>> searchHousingByCountry(@PathVariable("COUNTRY_NAME") String countryName,
                                                                @PathVariable("PAGE_NUM") int pageNumber,
                                                                @PathVariable("PAGE_SIZE") int pageSize,
                                                                @RequestBody HousingSearchDTO housingSearchDTO) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Housing> page = housingSearchService.searchByCountry(countryName, housingSearchDTO, pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
}
