package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.exceptions.InvalidLoginCredentialsException;
import mk.finki.ukim.epharmacy.model.tables.User;
import mk.finki.ukim.epharmacy.repository.tables.UserRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.UserService;
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

    @Override
    public User checkCredentials(String username, String password) throws InvalidLoginCredentialsException {
        Optional<User> user = findByUsername(username);
        if(user.isPresent() && user.get().getPassword().equals(password))
            return user.get();

        throw new InvalidLoginCredentialsException();
    }

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {


        return userRepository.save(user);
    }
}
