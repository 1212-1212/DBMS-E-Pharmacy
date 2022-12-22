package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Table(name="patient")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Patient extends User{

    public Patient(String username, String name, String surname, String email, String password, String streetName, Integer flatNumber) {
        super(username, name, surname, email, password, streetName, flatNumber);
    }

    public Patient() {

    }
}
