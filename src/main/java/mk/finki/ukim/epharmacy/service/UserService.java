package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.tables.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     User save(String username, String firstName, String lastName, String email, String password, String streetName, Integer flatNumber);
     Optional<User> findById(Long id);
     List<User> findAll();
    Optional<User> findByUsername(String username);




}
