package model;

public class Engineer {

	private int engineerId;
	private String engFirstName;
	private String engLastName;
	private String engCity;
	private int engSalary;
	private String engEmail;
	private String engPassword;
	private String engType;
	private int hodId;
	public Engineer(int engineerId, String engFirstName, String engLastName, String engCity, int engSalary,
			String engEmail, String engPassword, String engType,int Hodid) {
		this.engineerId = engineerId;
		this.engFirstName = engFirstName;
		this.engLastName = engLastName;
		this.engCity = engCity;
		this.engSalary = engSalary;
		this.engEmail = engEmail;
		this.engPassword = engPassword;
		this.engType = engType;
		this.hodId = Hodid;
	}
	
	public Engineer(String engFirstName, String engLastName, String engCity, int engSalary, String engEmail,
			String engPassword, String engType, int hodId) {
		this.engFirstName = engFirstName;
		this.engLastName = engLastName;
		this.engCity = engCity;
		this.engSalary = engSalary;
		this.engEmail = engEmail;
		this.engPassword = engPassword;
		this.engType = engType;
		this.hodId = hodId;
	}

	public int getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}
	public String getEngFirstName() {
		return engFirstName;
	}
	public void setEngFirstName(String engFirstName) {
		this.engFirstName = engFirstName;
	}
	public String getEngLastName() {
		return engLastName;
	}
	public void setEngLastName(String engLastName) {
		this.engLastName = engLastName;
	}
	public String getEngCity() {
		return engCity;
	}
	public void setEngCity(String engCity) {
		this.engCity = engCity;
	}
	public int getEngSalary() {
		return engSalary;
	}
	public void setEngSalary(int engSalary) {
		this.engSalary = engSalary;
	}
	public String getEngEmail() {
		return engEmail;
	}
	public void setEngEmail(String engEmail) {
		this.engEmail = engEmail;
	}
	public String getEngPassword() {
		return engPassword;
	}
	public void setEngPassword(String engPassword) {
		this.engPassword = engPassword;
	}
	public String getEngType() {
		return engType;
	}
	public void setEngType(String engType) {
		this.engType = engType;
	}
	public int getHodId() {
		return hodId;
	}
	public void setHodId(int hodId) {
		this.hodId = hodId;
	}
	@Override
	public String toString() {
		return "Engineer [engineerId=" + engineerId + ", engFirstName=" + engFirstName + ", engLastName=" + engLastName
				+ ", engCity=" + engCity + ", engSalary=" + engSalary + ", engEmail=" + engEmail + ", engPassword="
				+ engPassword + ", engType=" + engType + ", HodId=" + hodId + "]";
	}

	
	
}
