package pokedex.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokedex.entities.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String> {

}
