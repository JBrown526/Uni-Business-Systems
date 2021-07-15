package pokedex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokedex.dao.UserRepository;
import pokedex.entities.PokedexUser;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private UserRepository userRepository;
    private PokedexUser currentPokedexUser;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

        userRepository.save(new PokedexUser("jamie", "brown", "jamie@browm.com", "password"));
    }

    @Override
    public List<PokedexUser> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(PokedexUser pokedexUser) {
        currentPokedexUser = pokedexUser;
        userRepository.save(pokedexUser);
    }

    @Override
    public PokedexUser getCurrentPokedexUser() {
        return currentPokedexUser;
    }

    @Override
    public int getNumberOfUsers() {
        return (int) userRepository.count();
    }
}
