package cz.uhk.pro2kf2026.controller;

import cz.uhk.pro2kf2026.model.Cat;
import cz.uhk.pro2kf2026.service.CatService;
import cz.uhk.pro2kf2026.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cats") // Změněno z /dogs
public class CatController {

    private final CatService catService;
    private final UserService userService;

    @Autowired
    public CatController(CatService catService, UserService userService) {
        this.catService = catService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("cats", catService.getAllCats());
        return "cats_list"; // Cílí na HTML šablonu cats_list.html
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        model.addAttribute("cat", catService.getCat(id));
        return "cats_detail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cat", new Cat()); // OPRAVENO: nová Kočka, ne Pes
        model.addAttribute("users", userService.getAllUsers());
        return "cats_edit";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("cat", catService.getCat(id));
        model.addAttribute("users", userService.getAllUsers());
        return "cats_edit"; // Použije cats_edit.html
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cat cat) { // OPRAVENO: bere Cat z formuláře
        catService.saveCat(cat);
        return "redirect:/cats/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        catService.deleteCat(id); // OPRAVENO: předává se ID, ne objekt
        return "redirect:/cats/";
    }
}