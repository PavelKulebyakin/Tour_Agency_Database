package ru.mirea.database.controller.admin;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.database.data.dto.property.PropertyDTO;
import ru.mirea.database.data.entity.location.City;
import ru.mirea.database.data.entity.property.Owner;
import ru.mirea.database.data.entity.property.PropertyType;
import ru.mirea.database.data.entity.property.TypeOfFood;
import ru.mirea.database.service.data.property.PropertyService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/booking")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ModelAttribute("cities")
    public List<City> cities() {
        return propertyService.getCities();
    }
    @ModelAttribute("typesOfFood")
    public List<TypeOfFood> typesOfFood() {
        return propertyService.getTypesOfFood();
    }
    @ModelAttribute("owners")
    public List<Owner> owners() {
        return propertyService.getOwners();
    }
    @ModelAttribute("propertyTypes")
    public List<PropertyType> propertyTypes() {
        return propertyService.getPropertyTypes();
    }

    @GetMapping
    public String propertyView(Model model/*, @RequestParam(name = "error", required = false) boolean error, @RequestParam(name = "save", required = false) boolean save,
                           @RequestParam(name = "delete", required = false) boolean delete*/ ){
        Pageable pageable = PageRequest.of(0, 100, Sort.by("name"));
        model.addAttribute("properties", propertyService.findAll(pageable).getContent());
        return "property/property";
    }

    @GetMapping("save")
    public String saveView(Model model) {
        PropertyDTO input = new PropertyDTO();
        model.addAttribute("input", input);
        return "property/property_update";
    }

    @PostMapping("/save")
    public String saveProperty(Model model, @Valid @ModelAttribute("input") PropertyDTO property) {
        if(property.getId() == null) {
            propertyService.save(property);
        } else {
            propertyService.update(property);
        }
        return "redirect:/property?save=true";
    }

    @GetMapping("update/{id}")
    public String updateView(Model model, @PathVariable(name = "id") Long id) {
        PropertyDTO input = propertyService.findById(id);
        model.addAttribute("input", input);
        return "property/property_update";
    }

    @PostMapping("/delete/{id}")
    public String deleteProperty(Model model, @PathVariable("id") Long id) {
        try{
            propertyService.deleteById(id);
        } catch (DataIntegrityViolationException e){
//            model.addAttribute("errormessage", "Невозможно удалить сущность с id=" + id);
            return "redirect:/property?error=true";
        }
        return "redirect:/property?delete=true";
    }
}
