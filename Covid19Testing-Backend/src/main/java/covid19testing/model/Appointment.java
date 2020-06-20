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
    private Patient appointmentPatient;
    private TestCenter location;
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

    @ManyToOne(optional = false)
    public Patient getappointmentPatient() {
        return appointmentPatient;
    }

    public void setappointmentPatient(Patient patient) {
        this.appointmentPatient = patient;
    }

    @ManyToOne(optional = false)
    public TestCenter getLocation() {
        return location;
    }

    public void setLocation(TestCenter testCenter) {
        this.location = testCenter;
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
