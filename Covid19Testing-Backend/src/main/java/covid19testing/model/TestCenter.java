package covid19testing.model;

import java.util.Set;

@Entity
public class TestCenter{

        private String name;
	    private String address;
	    private String city;
	    private String province;
        private Set<Appointment> appointments;
        private Set<Test> tests;


        public String getName() {
                return this.name;
        }
        public void setName(String name){
                this.name = name;
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

        public Set<Test> getTests() {
                return tests;
        }

        public void setTests(Set<Test> tests) {
                this.tests = tests;
        }

        public Set<Appointment> getAppointments() {
                return appointments;
        }

        public void setAppointments(Set<Appointment> appointments) {
                this.appointments = appointments;
        }
}

