package si.tpo.fitin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.tpo.fitin.entities.Routine;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineRepository extends CrudRepository<Routine, Long> {
    Optional<Routine> findById(@Param("id") Integer id);
    List<Routine> findAll();
}
