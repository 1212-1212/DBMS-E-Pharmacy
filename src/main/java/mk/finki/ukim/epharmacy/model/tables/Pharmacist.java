package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Table(name = "pharmacist")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Pharmacist  extends User{




    public Pharmacist() {
    }
}
