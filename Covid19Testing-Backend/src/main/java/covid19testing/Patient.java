package covid19testing;

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

//	public void addPatient();
//	public void editPatient();
//	public void deletePatient();

}
