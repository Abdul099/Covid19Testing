package covid19testing.model;

import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Test{

	private boolean result;
	private int fever;
	private Status status;
	private Date date;
	private Time time;
	private Patient patient;
	private  TestCenter testCenter;

        public boolean getResult() {
                return this.result;
        }
        public void setResult(boolean result){
                this.result = result;
        }

        public int getFever() {
                return this.fever;
        }
        public void setFever(int Fever){
                this.fever = fever;
        }

        public Status getStatus() {
                return this.status;
        }
        public void setStatus(Status status){
                this.status = status;
        }

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

