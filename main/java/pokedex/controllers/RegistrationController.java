package pokedex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pokedex.entities.PokedexUser;
import pokedex.services.RegistrationService;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(value = "/register")
    public ModelAndView showRegistrationForm() {
        PokedexUser pokedexUser = new PokedexUser();
        return new ModelAndView("register", "pokedexUser", pokedexUser);
    }

    @GetMapping(value = "/profile")
    public ModelAndView showProfile() {

        return new ModelAndView("/profile", "pokedexUser",
                registrationService.getCurrentPokedexUser() != null
                        ? registrationService.getCurrentPokedexUser()
                        : new PokedexUser("John", "Doe", "johndoe@placeholder.co.uk", "password"));
    }

    @GetMapping(value = "/users")
    public ModelAndView showUsers() {

        return new ModelAndView("/users", "users", registrationService.getUsers());
    }

    @PostMapping(value = "/register")
    public String processRegistration(PokedexUser pokedexUser) {
        registrationService.addUser(pokedexUser);
        return "redirect:/profile";
    }
}
