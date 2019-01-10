package si.tpo.fitin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.tpo.fitin.entities.Routine;
import si.tpo.fitin.entities.Workout;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long>{
    Optional<Workout> findById(@Param("id") Integer id);
    List<Workout> findAll();
}
