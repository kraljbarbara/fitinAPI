package si.tpo.fitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.tpo.fitin.entities.*;
import si.tpo.fitin.model.ProfileModel;
import si.tpo.fitin.model.workoutModel;
import si.tpo.fitin.repositories.EquipmentRepository;
import si.tpo.fitin.repositories.RoutineHasRepository;
import si.tpo.fitin.repositories.RoutineRepository;
import si.tpo.fitin.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoutineHasRepository routineHasRepository;

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        return user.get();
    }

    @GetMapping("/users/{id}/routines")
    public List<Routine> getRoutines(@PathVariable("id") Integer id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();

        List<Routine> routines = new ArrayList<>();

        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            routines.add(routineHasUser.getRoutineId());
        }

        return routines;
    }

    @GetMapping("/users/{id}/routines/{routine_id}")
    public Routine getRoutine(@PathVariable("id") Integer id, @PathVariable("routine_id") Integer routine_id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();

        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            if (routineHasUser.getRoutineId().getId().equals(routine_id)) {
                return routineHasUser.getRoutineId();
            } else {
                throw new Exception(String.format("User with id %d doesn't have this routine", id));
            }
        }
        return new Routine();
    }


    @GetMapping("/users/{id}/routines/{routine_id}/workouts")
    public List<workoutModel> getWorkouts(@PathVariable("id") Integer id, @PathVariable("routine_id") Integer routine_id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();
        List<workoutModel> workouts = new ArrayList<>();
        Routine routine = new Routine();

        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            if (routineHasUser.getRoutineId().getId().equals(routine_id)) {
                routine = routineHasUser.getRoutineId();
                for (WorkoutHasRoutine workoutHasRoutine : routine.getWorkoutHasRoutineList()) {
                    Workout wo = workoutHasRoutine.getWorkoutId();
                    Equipment eq = wo.getEquipmentId();
                    workoutModel dummy = new workoutModel(wo.getName(), wo.getDuration(), wo.getLocation(), wo.getCategory(), wo.getMotivationalMessage(), wo.getK(),
                            eq.getName());
                    workouts.add(dummy);
                }
            }
        }
        return workouts;
    }

    @GetMapping("/users/{id}/routines/{routine_id}/equipments")
    public List<Equipment> getEquipments(@PathVariable("id") Integer id, @PathVariable("routine_id") Integer routine_id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();
        List<Equipment> eqs = new ArrayList<>();
        Routine routine = new Routine();

        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            if (routineHasUser.getRoutineId().getId().equals(routine_id)) {
                routine = routineHasUser.getRoutineId();
                for (WorkoutHasRoutine workoutHasRoutine : routine.getWorkoutHasRoutineList()) {
                    Workout wo = workoutHasRoutine.getWorkoutId();
                    eqs.add(wo.getEquipmentId());
                }
            }
        }
        return eqs;
    }

    @GetMapping("/users/{id}/routines/{routine_id}/categories")
    public List<String> getCategory(@PathVariable("id") Integer id, @PathVariable("routine_id") Integer routine_id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();
        List<String> categories = new ArrayList<>();
        Routine routine = new Routine();

        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            if (routineHasUser.getRoutineId().getId().equals(routine_id)) {
                routine = routineHasUser.getRoutineId();
                for (WorkoutHasRoutine workoutHasRoutine : routine.getWorkoutHasRoutineList()) {
                    Workout wo = workoutHasRoutine.getWorkoutId();
                    if (!categories.contains(wo.getCategory())) {
                        categories.add(wo.getCategory());
                    }
                }
            }
        }

        return categories;
    }

    @GetMapping("/users/{id}/routines/{routine_id}/equipments/{equipment}")
    public List<workoutModel> getWorkouts(@PathVariable("id") Integer id, @PathVariable("routine_id") Integer routine_id, @PathVariable("equipment") String equipment) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();
        List<workoutModel> workouts = new ArrayList<>();
        Routine routine = new Routine();
        for (RoutineHasUser routineHasUser : user.getRoutineHasUserList()) {
            if (routineHasUser.getRoutineId().getId().equals(routine_id)) {
                routine = routineHasUser.getRoutineId();
                for (WorkoutHasRoutine workoutHasRoutine : routine.getWorkoutHasRoutineList()) {
                    Workout wo = workoutHasRoutine.getWorkoutId();
                    Equipment eq = equipmentRepository.findByName(equipment).get();
                    if (wo.getEquipmentId().getId() == eq.getId() && eq.getName().equals(equipment)) {
                        workoutModel dummy = new workoutModel(wo.getName(), wo.getDuration(), wo.getLocation(), wo.getCategory(), wo.getMotivationalMessage(), wo.getK(),
                                eq.getName());
                        workouts.add(dummy);
                    }
                }
            }
        }
        return workouts;
    }

    @GetMapping("/users/{id}/profile")
    public ProfileModel profile(@PathVariable("id") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }
        User u = user.get();
        ProfileModel profile = new ProfileModel(u.getVip(), u.getBankAccount(), u.getCurrentWeight(), u.getGoalWeight(), u.getStartingWeight());
        return profile;
    }

    @PostMapping("/users/{id}/profile/update")
    public void profileUpdate(@RequestBody ProfileModel req, @PathVariable("id") Integer id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception(String.format("User with id %d doesn't exist.", id));
        }

        User user = optionalUser.get();
        if (req.getvip() != null)
            user.setVip(req.getvip());
        if (req.getbankAccount() != null)
            user.setBankAccount(req.getbankAccount());
        if (req.getstartingWeight() != null)
            user.setStartingWeight(req.getstartingWeight());
        if (req.getcurrentWeight() != null)
            user.setCurrentWeight(req.getcurrentWeight());
        if (req.getgoalWeight() != null)
            user.setGoalWeight(req.getgoalWeight());

        userRepository.save(user);
    }
}
