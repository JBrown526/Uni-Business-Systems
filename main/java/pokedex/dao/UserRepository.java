package pokedex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokedex.entities.PokedexUser;

@Repository
public interface UserRepository extends JpaRepository<PokedexUser, String> {

}
