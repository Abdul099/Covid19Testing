package covid19testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Application {

    private int fever;
    private boolean cough;
    private boolean shortnessBreath;
    private String otherSymptoms;
    private boolean result;
    private Patient applicant;
    private String applicationID;

    public int getFever() {
        return this.fever;
    }

    public void setFever(int Fever) {
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
