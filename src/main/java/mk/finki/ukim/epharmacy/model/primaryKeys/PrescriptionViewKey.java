package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class PrescriptionViewKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "prescription_id")
    private int prescriptionId;

    public PrescriptionViewKey(int userId, int prescriptionId) {
        this.userId = userId;
        this.prescriptionId = prescriptionId;
    }

    public PrescriptionViewKey() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionViewKey that = (PrescriptionViewKey) o;
        return userId == that.userId && prescriptionId == that.prescriptionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, prescriptionId);
    }
}
