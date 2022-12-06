package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.tables.User;
import mk.finki.ukim.epharmacy.repository.UserRepository;
import mk.finki.ukim.epharmacy.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(String username, String firstName, String lastName, String email, String password, String streetName, Integer flatNumber) {
        return userRepository.save(new User(username, firstName, lastName, email, password, streetName, flatNumber));
    }
}
