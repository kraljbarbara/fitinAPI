package si.tpo.fitin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import si.tpo.fitin.entities.User;
import si.tpo.fitin.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

}
