package ru.mirea.database.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

@RestController
@RequestMapping("api/property")
public class RestPropertyController {

    protected final PropertyService propertyService;

    @Autowired
    public RestPropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("housing")
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyDTO> getProperties(@RequestParam(name = "num", required = false, defaultValue = "0") int pageNumber,
                                           @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<PropertyDTO> page = propertyService.findAll(pageable);
        return page.getContent();
    }

}
