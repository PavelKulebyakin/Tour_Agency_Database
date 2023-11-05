package ru.mirea.database.controller;

import jakarta.validation.constraints.NotEmpty;
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


    @PostMapping("housing")
    @ResponseStatus(HttpStatus.OK)
    public List<Housing> searchHousing(@RequestParam(name = "num", required = false, defaultValue = "0") int pageNumber,
                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize,
                                          @RequestBody(required = false) HousingSearchDTO housingSearchDTO) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Housing> page = housingSearchService.search(housingSearchDTO, pageable);
        return page.getContent();
    }


    @PostMapping("housing/country/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Housing> searchHousingByCountry(@PathVariable("name") String countryName,
                                                @RequestParam(name = "num", required = false, defaultValue = "0") int pageNumber,
                                                @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize,
                                                @RequestBody HousingSearchDTO housingSearchDTO) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Housing> page = housingSearchService.searchByCountry(countryName, housingSearchDTO, pageable);
        return page.getContent();
    }
}
