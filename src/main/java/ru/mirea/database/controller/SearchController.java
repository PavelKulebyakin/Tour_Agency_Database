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
    public ResponseEntity<List<Housing>> searchHousing(@PathVariable(name = "PAGE_NUM") int pageNumber,
                                                       @PathVariable(name = "PAGE_SIZE") int pageSize,
                                                       @RequestBody HousingSearchDTO housingSearchDTO) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Housing> page = housingSearchService.search(housingSearchDTO, pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
}
