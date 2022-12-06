package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

@Data
@Table(name = "\"user\"")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_surname", nullable = false)
    private String surname;

    @Column(name = "user_email",  nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "flat_number", nullable = false)
    private Integer flatNumber;

    public User(Long userId) {
        this.userId = userId;
    }

    public User(String username, String name, String surname, String email, String password, String streetName, Integer flatNumber) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
    }

    public User(Long userId, String username, String name, String surname, String email, String password, String streetName, Integer flatNumber) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
    }

    public User() {
    }
}
