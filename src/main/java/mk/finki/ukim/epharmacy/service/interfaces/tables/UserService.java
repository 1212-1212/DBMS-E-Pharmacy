package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.exceptions.InvalidLoginCredentialsException;
import mk.finki.ukim.epharmacy.model.tables.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     User save(User user);
     Optional<User> findById(Long id);
     List<User> findAll();
    Optional<User> findByUsername(String username);

    User checkCredentials(String username, String password) throws InvalidLoginCredentialsException;




}
