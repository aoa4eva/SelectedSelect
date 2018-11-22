package me.afua.checkedselect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    CarRepository cars;
    @GetMapping("/")
    String addCar(Model model)
    {
        model.addAttribute("cars",cars.findAll());
        model.addAttribute("aCar",new Car());
        return "index";
    }

    @PostMapping("/")
    String saveCar(@ModelAttribute("aCar") Car theCar)
    {
        cars.save(theCar);
        return "redirect:/";
    }
}
