package si.tpo.fitin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import si.tpo.fitin.entities.Equipment;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    List<Equipment> findAll();
    Optional<Equipment> findByName(@Param("name")String name);
    Optional<Equipment> findById(@Param("id") Integer id);
}
