package ru.mirea.database.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mirea.database.data.dto.property.PropertyDTO;

@Controller
public class PropertyController {

    @GetMapping
    public String property(Model model) {
        model.addAttribute(new PropertyDTO());
        return "property";
    }
}
