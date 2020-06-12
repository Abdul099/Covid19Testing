package covid19testing;

import java.sql.Date;
import java.sql.Time;

public class Appointment{

	private Date date;
	private Time time;
	getPatient();

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

}
