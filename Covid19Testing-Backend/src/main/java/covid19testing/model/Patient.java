package covid19testing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Patient{
	
	private String name;	
	private String surname;
	private String address;
	private String city;
	private String province;	
	private int insurance;
	private String travel;
	private String preCondition;
	private String medication;	
	private Set<Application> applications;
	private Set<Appointment>  appointments;
   	private Set<Test> tests;

	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name = name;	
	}

        public String getSurame() {
                return this.surname;
        }
        public void setSurname(String surname){
                this.surname = surname;
        }

        public String getAddress() {
                return this.address;
        }
        public void setAddress(String address){
                this.address = address;
        }

        public String getCity() {
                return this.city;
        }
        public void setCity(String city){
                this.city = city;
        }
	
        public String getProvince() {
                return this.province;
        }
        public void setProvince(String province){
                this.province = province;
        }


	    @Id
        public int getInsurance() {
                return this.insurance;
        }
        public void setInsurance(int insurance){
                this.insurance = insurance;
        }	

        public String getTravel() {
                return this.travel;
        }
        public void setTravel(String travel){
                this.travel = travel;
        }	

        public String getPreCondition() {
                return this.preCondition;
        }
        public void setPreCondition(String preCondition){
                this.preCondition = preCondition;
     	}

        public String getMedication() {
                return this.medication;
        }
        public void setMedication(String medication){
                this.medication = medication;
        }

        public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
    //	public void addPatient();
//	public void editPatient();
//	public void deletePatient();

}
