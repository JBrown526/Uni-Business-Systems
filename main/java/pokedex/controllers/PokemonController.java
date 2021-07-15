package pokedex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pokedex.entities.Pokemon;
import pokedex.services.PokemonService;

import javax.persistence.EntityManager;

@Controller
public class PokemonController {

    private PokemonService pokemonService;
    private EntityManager em;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(value = "/pokemon")
    public ModelAndView showPokemon() {

        return new ModelAndView("pokemon", "pokemon",
                pokemonService.getCurrentPokemon() != null
                        ? pokemonService.getCurrentPokemon()
                        : pokemonService.getPokemonList().get(0)
        );
    }

    @GetMapping(value = "/pokedex")
    public ModelAndView showPokemonList() {

        return new ModelAndView("/pokedex", "pokemonList", pokemonService.getPokemonList());
    }

    @GetMapping(value = "/addPokemon")
    public ModelAndView showAddPokemon() {
        Pokemon pokemon = new Pokemon();
        return new ModelAndView("/addPokemon", "pokemon", pokemon);
    }

    @PostMapping(value = "/addPokemon")
    public String processPokemonAddition(Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);
        return "redirect:/pokemon";
    }

    @RequestMapping(value = "/pokedex")
    public ModelAndView changeCurrentPokemon(Pokemon pokemon) {
        pokemonService.setCurrentPokemon(pokemon);
        return new ModelAndView("/pokemon", "pokemon", pokemonService.getCurrentPokemon());
    }
}
