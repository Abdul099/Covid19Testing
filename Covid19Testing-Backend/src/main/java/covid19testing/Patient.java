package covid19testing;

public class Patient{
	
	private String name;	

	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name = name;	
	}
	
	private String surname;

        public String getSurame() {
                return this.surname;
        }
        public void setSurname(String surname){
                this.surname = surname;
        }

	private String address;

        public String getAddress() {
                return this.address;
        }
        public void setAddress(String addres){
                this.adress = adress;
        }

	private String city;

        public String getCity() {
                return this.city;
        }
        public void setCity(String city){
                this.City = city;
        }
	
	private String province;

        public String getProvince() {
                return this.province;
        }
        public void setProvince(String province){
                this.province = province;
        }

	private int insurance;

        public int getInsurance() {
                return this.insurance;
        }
        public void setInsurance(int insurance){
                this.insurance = insurance;
        }	
	
	private String travel;

        public String getTravel() {
                return this.travel;
        }
        public void setTravel(String travel){
                this.travel = travel;
        }	

	private String preCondition;

        public String getPreCondition() {
                return this.preCondition;
        }
        public void setPreCondition(String preCondition){
                this.preCondition = preCondition;
        }
	
	private String medication;

        public String getMedication() {
                return this.medication;
        }
        public void setMedication(String medication){
                this.medication = medication;
        }	

	public void addPatient();
	public void editPatient();
	public void deletePatient();

}
