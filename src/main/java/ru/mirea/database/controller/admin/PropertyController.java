package ru.mirea.database.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.property.PropertyInputDTO;
import ru.mirea.database.data.dto.property.PropertyOutputDTO;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;
import java.util.SortedMap;

@Controller
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/property")
    public String property(Model model) {                                               // TODO: 29.11.2023 change later

        Pageable pageable = PageRequest.of(0, 10);
        Page<PropertyOutputDTO> page = propertyService.findAll(pageable);
        List<PropertyOutputDTO> properties = page.getContent();
        model.addAttribute("properties", properties);

        SortedMap<String, Long> cities = propertyService.getCityNames();
        model.addAttribute("cities", cities);

        SortedMap<String, Long> typesOfFood = propertyService.getFoodTypeNames();
        model.addAttribute("typesOfFood", typesOfFood);

        SortedMap<String, Long> owners = propertyService.getOwnerNames();
        model.addAttribute("owners", owners);

        SortedMap<String, Long> propertyTypes = propertyService.getPropertyTypeNames();
        model.addAttribute("propertyTypes", propertyTypes);

        model.addAttribute("input", new PropertyInputDTO());
        return "property";
    }

    @PostMapping("/property/add")
    public String addProperty(@ModelAttribute PropertyInputDTO propertyInputDTO) {
        propertyService.save(propertyInputDTO);
        return "redirect:/property";
    }

    @PostMapping("/property/delete/{id}")
    public String deleteProperty(@PathVariable("id") Long id) {
        propertyService.deleteById(id);
        return "redirect:/property";
    }
}
