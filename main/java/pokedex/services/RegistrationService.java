package pokedex.services;

import pokedex.entities.PokedexUser;

import java.util.List;

public interface RegistrationService {

    List<PokedexUser> getUsers();

    void addUser(PokedexUser pokedexUser);

    PokedexUser getCurrentPokedexUser();

    int getNumberOfUsers();
}
