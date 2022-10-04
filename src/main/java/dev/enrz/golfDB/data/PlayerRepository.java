package dev.enrz.golfDB.data;


import dev.enrz.golfDB.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
