package pokedex.services;

import pokedex.entities.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getPokemonList();

    void addPokemon(Pokemon pokemon);

    void setCurrentPokemon(Pokemon pokemon);

    Pokemon getCurrentPokemon();

    int getNumberOfPokemon();
}
