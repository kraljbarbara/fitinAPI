package si.tpo.fitin.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.tpo.fitin.entities.RoutineHasUser;
import si.tpo.fitin.entities.User;
import si.tpo.fitin.entities.WorkoutHasRoutine;

import java.util.List;

@Repository
public interface WorkoutHasRoutineRepository extends CrudRepository<WorkoutHasRoutine, Long> {
    List<WorkoutHasRoutine> findAllByWorkoutId(@Param("workout_id") Integer id);
}
