package si.tpo.fitin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "workout_has_routine", schema = "mydb", catalog = "")
public class WorkoutHasRoutine {
    private Integer id;
    private Integer workoutId;
    private Integer routineId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutHasRoutine that = (WorkoutHasRoutine) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Basic
    @Column(name = "workout_id", nullable = false)
    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    @Basic
    @Column(name = "routine_id", nullable = false)
    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }
}
