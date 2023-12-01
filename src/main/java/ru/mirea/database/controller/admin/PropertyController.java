package ru.mirea.database.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.Property;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

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
        Page<Property> page = propertyService.findAll(pageable);
        List<Property> properties = page.getContent();
        model.addAttribute("properties", properties);

        List<City> cities = propertyService.getAllCities();
        model.addAttribute("cities", cities);

        List<TypeOfFood> typesOfFood = propertyService.getAllTypesOfFood();
        model.addAttribute("typesOfFood", typesOfFood);

        List<Owner> owners = propertyService.getAllOwners();
        model.addAttribute("owners", owners);

        List<PropertyType> propertyTypes = propertyService.getAllPropertyTypes();
        model.addAttribute("propertyTypes", propertyTypes);

        model.addAttribute("newProperty", new PropertyDTO());
        return "property";
    }

    @PostMapping("/property")
    public String addProperty(@ModelAttribute PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
        return "redirect:/property";
    }

//    @DeleteMapping("/property")
//    public String deleteProperty(@ModelAttribute Long id) {
//        propertyService.deleteProperty(id);
//        return "redirect:/property";
//    }
}
