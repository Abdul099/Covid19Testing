package covid19testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
public class Test {

    private boolean result;
    private int fever;
    private Status status;
    private Date date;
    private Time time;
    private Patient patient;
    private TestCenter testCenter;
    private String testID;

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getFever() {
        return this.fever;
    }

    public void setFever(int Fever) {
        this.fever = fever;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @ManyToOne(optional = false)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(optional = false)
    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }

    public void setTestID(String value) {
        this.testID = value;
    }

    public void setTransactionID() {
        this.testID = UUID.randomUUID().toString();
    }

    @Id
    public String getTransactionID() {
        return this.testID;
    }
}

