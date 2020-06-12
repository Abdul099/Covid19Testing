package covid19testing;

public class ApplicationForTest{

        private int fever;

        public int getFever() {
                return this.fever;
        }
        public void setFever(int Fever){
                this.fever = fever;
        }
	
	private boolean cough;

        public boolean getCough() {
                return this.cough;
        }
        public void setCough(boolean cough){
                this.cough = cough;
        }

	private boolean shortnessBreath;

        public boolean getShortnessBreath() {
                return this.shortnessBreath;
        }
        public void setShortnessBreath(boolean shortnessBreath){
                this.shortnessBreath = shortnessBreath;
        }

	private String otherSymptoms;

        public String getOtherSymptoms() {
                return this.otherSymptoms;
        }
        public void setOtherSymptoms(String otherSymptoms){
                this.otherSymptoms = otherSymptoms;
        }
	
	private boolean result;

        public boolean getResult() {
                return this.result;
        }
        public void setResult(boolean result){
                this.result = result;
        }


}
