package covid19testing;
  
public class TestCenter{

        private String name;

        public String getName() {
                return this.name;
        }
        public void setName(String name){
                this.name = name;
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

        public int proximityToPatient();
        public String rankTestCenter();
        public void selectTestCenter();

}
~   
