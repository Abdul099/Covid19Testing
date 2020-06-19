package covid19testing.model;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Appointment{

	private Date date;
	private Time time;
	private Patient patient;
	private TestCenter testCenter;

	public Date getDate() {
                return this.date;
        }
        public void setDate(Date date){
                this.date = date;
        }

        public Time getTime() {
                return this.time;
        }
        public void setTime(Time time){
                this.time = time;
        }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TestCenter getTestCenter() {
        return testCenter;
    }

    public void setTestCenter(TestCenter testCenter) {
        this.testCenter = testCenter;
    }
}
