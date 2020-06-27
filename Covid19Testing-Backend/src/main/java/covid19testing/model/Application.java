package covid19testing.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Application {

    private double fever;
    private boolean cough;
    private boolean shortnessBreath;
    private String otherSymptoms;
    private boolean result;
    private Patient applicant;
    private String applicationID;

	@Enumerated(EnumType.STRING)
        private Tiredness tiredness;

	@Enumerated(EnumType.STRING)
        private SoreThroat soreThroat;

	@Enumerated(EnumType.STRING)
        private Aches aches;

	@Enumerated(EnumType.STRING)
        private ChestPain chestPain;

	@Enumerated(EnumType.STRING)
        private ApplicationResult applicationResult;

    public double getFever() {
        return this.fever;
    }

    public void setFever(double Fever) {
        this.fever = fever;
    }

    public boolean getCough() {
        return this.cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean getShortnessBreath() {
        return this.shortnessBreath;
    }

    public void setShortnessBreath(boolean shortnessBreath) {
        this.shortnessBreath = shortnessBreath;
    }

    public String getOtherSymptoms() {
        return this.otherSymptoms;
    }

    public void setOtherSymptoms(String otherSymptoms) {
        this.otherSymptoms = otherSymptoms;
    }

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @ManyToOne(optional = false)
    public Patient getApplicant() {
        return applicant;
    }

    public void setApplicant(Patient patient) {
        this.applicant = patient;
    }

    public void setApplicationID(String value) {
        this.applicationID = value;
    }

    public void setApplicationID() {
        this.applicationID = UUID.randomUUID().toString();
    }

    @Id
    public String getApplicationID() {
        return this.applicationID;
    }
}
