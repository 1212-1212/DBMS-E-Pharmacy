package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name = "administrator")
@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Administrator extends User{



    public Administrator() {
    }
}
