package dev.enrz.golfDB.data;

import dev.enrz.golfDB.models.Course;
import dev.enrz.golfDB.models.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository<Round, Integer> {

}
