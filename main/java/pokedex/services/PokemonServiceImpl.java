package pokedex.services;

import org.springframework.stereotype.Service;
import pokedex.dao.PokemonRepository;
import pokedex.entities.Pokemon;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;
    private Pokemon currentPokemon;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getPokemonList() {
        return pokemonRepository.findAll();
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        currentPokemon = pokemon;
        pokemonRepository.save(pokemon);
    }

    @Override
    public void setCurrentPokemon(Pokemon pokemon) {
        currentPokemon = pokemon;
    }

    @Override
    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    @Override
    public int getNumberOfPokemon() {
        return (int) pokemonRepository.count();
    }
}
