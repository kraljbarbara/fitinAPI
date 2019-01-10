package si.tpo.fitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.tpo.fitin.entities.Equipment;
import si.tpo.fitin.entities.Routine;
import si.tpo.fitin.entities.Workout;
import si.tpo.fitin.entities.WorkoutHasRoutine;
import si.tpo.fitin.model.workoutModel;
import si.tpo.fitin.repositories.EquipmentRepository;
import si.tpo.fitin.repositories.RoutineRepository;
import si.tpo.fitin.repositories.WorkoutHasRoutineRepository;
import si.tpo.fitin.repositories.WorkoutRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class RoutineController {

    @Autowired
    RoutineRepository routineRepository;

    @Autowired
    WorkoutHasRoutineRepository workoutHasRoutineRepository;

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("/routines")
    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    @GetMapping("/routines/{routine_id}")
    public Routine getRoutine(@PathVariable("routine_id") Integer routine_id) throws Exception {
        Routine routine;
        try{
            routine = routineIfPresent(routine_id);
        }catch(Exception e){
            throw e;
        }
        return routine;
    }

    @GetMapping("/routines/{routine_id}/workouts")
    public List<workoutModel> getRoutinesWorkouts(@PathVariable("routine_id") Integer routine_id) throws Exception {
        Routine routine;
        try{
            routine = routineIfPresent(routine_id);
        }catch(Exception e){
            throw e;
        }

        List<workoutModel> workouts = new ArrayList<>();

        for (WorkoutHasRoutine workoutHasRoutine: routine.getWorkoutHasRoutineList()) {
            Workout wo = workoutHasRoutine.getWorkoutId();
            workoutModel dummy = new workoutModel(wo.getName(), wo.getDuration(), wo.getLocation(), wo.getCategory(), wo.getMotivationalMessage(), wo.getK(),
                    equipmentRepository.findById(wo.getId()).get().getName());
            workouts.add(dummy);
        }

        return workouts;
    }

    @GetMapping("/routines/{routine_id}/equipment")
    public List<Equipment> getRoutinesEquipment(@PathVariable("routine_id") Integer routine_id) throws Exception {
        Routine routine;
        try{
            routine = routineIfPresent(routine_id);
        }catch(Exception e){
            throw e;
        }

        List<Equipment> equipment = new ArrayList<>();

        for (WorkoutHasRoutine workoutHasRoutine: routine.getWorkoutHasRoutineList()) {
            Workout wo = workoutHasRoutine.getWorkoutId();
            equipment.add(equipmentRepository.findById(wo.getId()).get());
        }

        return equipment;
    }

    @GetMapping("/routines/{routine_id}/categories")
    public List<String> getRoutineCategory(@PathVariable("routine_id") Integer routine_id) throws Exception {
        Routine routine;
        try{
            routine = routineIfPresent(routine_id);
        }catch(Exception e){
            throw e;
        }

        List<String> categories = new ArrayList<>();

        for (WorkoutHasRoutine workoutHasRoutine: routine.getWorkoutHasRoutineList()) {
            Workout wo = workoutHasRoutine.getWorkoutId();
            if(!categories.contains(wo.getCategory())){
                categories.add(wo.getCategory());
            }
        }

        return categories;
    }

    @GetMapping("/workouts")
    public List<workoutModel> getAllWorkouts(){
        List<workoutModel> workouts = new ArrayList<>();
        Equipment eq = new Equipment();


        for(Workout wo : workoutRepository.findAll()){
            eq = wo.getEquipmentId();
            workoutModel dummy = new workoutModel(wo.getName(), wo.getDuration(), wo.getLocation(), wo.getCategory(), wo.getMotivationalMessage(), wo.getK(),
                   eq.getName());
            workouts.add(dummy);
        }
        return workouts;
    }

    private Routine routineIfPresent(Integer routine_id) throws Exception {
        Optional<Routine> routine = routineRepository.findById(routine_id);

        if(routine.isPresent()){
            return routine.get();
        }

        throw new Exception(String.format("Routine with id %d doesn't exist", routine_id));
    }
}
