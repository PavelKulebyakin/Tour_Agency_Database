package ru.mirea.database.controller.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.search.SearchCriteriaDTO;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.service.data.property.PropertyService;
import ru.mirea.database.service.search.PropertySearchService;

import java.util.List;

@RestController
@RequestMapping("api/search/property")
public class PropertySearchController {

    protected final PropertySearchService searchService;

    public PropertySearchController(PropertySearchService propertySearchService, PropertyService propertyService) {
        this.searchService = propertySearchService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Property> searchPropertyWithCriteria(@RequestParam(name = "num", required = false, defaultValue = "0") int pageNumber,
                                                              @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize,
                                                              @RequestBody SearchCriteriaDTO propertySearchCriteria) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Property> page = searchService.search(propertySearchCriteria, pageable);
        return page.getContent();
    }

//    @PostMapping("housing/country/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Housing> searchHousingByCountry(@PathVariable("name") String countryName,
//                                                @RequestParam(name = "num", required = false, defaultValue = "0") int pageNumber,
//                                                @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize,
//                                                @RequestBody HousingSearchDTO housingSearchDTO) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<Housing> page = searchService.searchByCountry(countryName, housingSearchDTO, pageable);
//        return page.getContent();
//    }
}
