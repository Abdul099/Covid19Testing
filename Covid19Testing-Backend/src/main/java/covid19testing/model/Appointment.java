package covid19testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
public class Appointment {

    private Date date;
    private Time time;
    private Patient patient;
    private TestCenter testCenter;
    private String appointmentID;

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

    public void setTransactionID(String value) {
        this.appointmentID = value;
    }

    public void setTransactionID() {
        this.appointmentID = UUID.randomUUID().toString();
    }

    @Id
    public String getTransactionID() {
        return this.appointmentID;
    }
}
