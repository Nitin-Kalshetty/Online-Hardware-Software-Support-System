package model;

public class Employee {
	
	private int empId;
	private String empFirstname;
	private String empLastname;
	private String empCity;
	private int empSalary;
	private String empEmail;
	private String empPassword;
	public Employee(int empId, String empFirstname, String empLastname, String empCity, int empSalary, String empEmail,
			String empPassword) {
		this.empId = empId;
		this.empFirstname = empFirstname;
		this.empLastname = empLastname;
		this.empCity = empCity;
		this.empSalary = empSalary;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
	}
	
	public Employee(String empFirstname, String empLastname, String empCity, int empSalary, String empEmail,
			String empPassword) {
		super();
		this.empFirstname = empFirstname;
		this.empLastname = empLastname;
		this.empCity = empCity;
		this.empSalary = empSalary;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpFirstname() {
		return empFirstname;
	}
	public void setEmpFirstname(String empFirstname) {
		this.empFirstname = empFirstname;
	}
	public String getEmpLastname() {
		return empLastname;
	}
	public void setEmpLastname(String empLastname) {
		this.empLastname = empLastname;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstname=" + empFirstname + ", empLastname=" + empLastname
				+ ", empCity=" + empCity + ", empSalary=" + empSalary + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + "]";
	}
	
	
}
