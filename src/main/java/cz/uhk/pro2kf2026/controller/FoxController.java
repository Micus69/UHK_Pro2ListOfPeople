package cz.uhk.pro2kf2026.controller;

import cz.uhk.pro2kf2026.model.Fox;
import cz.uhk.pro2kf2026.service.FoxService;
import cz.uhk.pro2kf2026.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foxs")
public class FoxController {

    private final FoxService foxService;
    private final UserService userService;

    @Autowired
    public FoxController(FoxService foxService, UserService userService) {
        this.foxService = foxService;
        this.userService = userService;
    }

    // 1. Zobrazení seznamu všech lišek
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("foxs", foxService.getAllFoxes());
        return "foxs_list";
    }

    // 2. Zobrazení detailu jedné lišky podle ID
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("fox", foxService.getFox(id));
        return "foxs_detail";
    }

    // 3. Formulář pro vytvoření nové lišky
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("fox", new Fox());
        model.addAttribute("users", userService.getAllUsers()); // Pro výběr majitele
        return "foxs_edit";
    }

    // 4. Formulář pro editaci stávající lišky
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("fox", foxService.getFox(id));
        model.addAttribute("users", userService.getAllUsers()); // Pro změnu majitele
        return "foxs_edit";
    }

    // 5. Zpracování odeslaného formuláře (Uložení / Aktualizace)
    @PostMapping("/save")
    public String save(@ModelAttribute Fox fox) {
        foxService.saveFox(fox);
        return "redirect:/foxs/";
    }

    // 6. Smazání lišky
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        foxService.deleteFox(id);
        return "redirect:/foxs/";
    }
}