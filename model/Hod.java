package model;

public class Hod {
	private int Hod;
	private String HodFirstName;
	private String HodLastName;
	private String HodCity;
	private String HodEmail;
	private String HodPassword;
	public Hod(int hod, String hodFirstName, String hodLastName, String hodCity, String hodEmail, String hodPassword) {
		Hod = hod;
		HodFirstName = hodFirstName;
		HodLastName = hodLastName;
		HodCity = hodCity;
		HodEmail = hodEmail;
		HodPassword = hodPassword;
	}
	public int getHod() {
		return Hod;
	}
	public void setHod(int hod) {
		Hod = hod;
	}
	public String getHodFirstName() {
		return HodFirstName;
	}
	public void setHodFirstName(String hodFirstName) {
		HodFirstName = hodFirstName;
	}
	public String getHodLastName() {
		return HodLastName;
	}
	public void setHodLastName(String hodLastName) {
		HodLastName = hodLastName;
	}
	public String getHodCity() {
		return HodCity;
	}
	public void setHodCity(String hodCity) {
		HodCity = hodCity;
	}
	public String getHodEmail() {
		return HodEmail;
	}
	public void setHodEmail(String hodEmail) {
		HodEmail = hodEmail;
	}
	public String getHodPassword() {
		return HodPassword;
	}
	public void setHodPassword(String hodPassword) {
		HodPassword = hodPassword;
	}
	@Override
	public String toString() {
		return "Hod [Hod=" + Hod + ", HodFirstName=" + HodFirstName + ", HodLastName=" + HodLastName + ", HodCity="
				+ HodCity + ", HodEmail=" + HodEmail + ", HodPassword=" + HodPassword + "]";
	}
	
	

}
