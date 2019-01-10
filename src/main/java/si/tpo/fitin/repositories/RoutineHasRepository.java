package si.tpo.fitin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.tpo.fitin.entities.Routine;
import si.tpo.fitin.entities.RoutineHasUser;
import si.tpo.fitin.entities.User;

import java.util.List;

@Repository
public interface RoutineHasRepository extends CrudRepository<RoutineHasUser, Long> {
    List<RoutineHasUser> findAllByUserId(@Param("userId") User user);
}
