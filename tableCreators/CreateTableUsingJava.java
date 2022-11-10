package tableCreators;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTableUsingJava {

	public static void main(String[] args) {
		
		Connection conn = DBUtilityTable.provideConnection();
		
		try {
			PreparedStatement db1 = conn.prepareStatement("create database sb101Project");
			db1.execute();
			db1 = conn.prepareStatement("use sb101Project");
			db1.execute();
			PreparedStatement createHod = conn.prepareStatement("create table HOD(HodId int primary key auto_increment,HodFirstName varchar(15),HodLastName varchar(15),HodCity varchar(12),HodEmail varchar(20),HodPassword varchar(15))");
			createHod.execute();
			createHod = conn.prepareStatement("alter table HOD auto_increment=5000");
			createHod.execute();
			PreparedStatement createEmp = conn.prepareStatement("create table Employee(employeeId int primary key auto_increment,empFirstName varchar(15),empLastName varchar(15),empCity varchar(12),empSalary int,empEmail varchar(20),empPassword varchar(15))");
			createEmp.execute();
			createEmp = conn.prepareStatement("alter table Employee auto_increment=1000");
			createEmp.execute();
			PreparedStatement createEng = conn.prepareStatement("create table Engineer(EngineerId int primary key auto_increment,engFirstName varchar(15),engLastName varchar(15),engCity varchar(12),engSalary int,engEmail varchar(20),engPassword varchar(15),engType varchar(12),hodId int)");
			createEng.execute();
			createEng = conn.prepareStatement("alter table Engineer auto_increment=450");
			createEng.execute();
			PreparedStatement createComplaints = conn.prepareStatement("create table Complaints(complainId int primary key auto_increment,EmployeeId int,EngineerId int,status varchar(12),Type varchar(12),"
					+ "foreign key(EmployeeId) references employee(employeeId),foreign key(EngineerId) references Engineer(EngineerId))");
			createComplaints.execute();
			createComplaints = conn.prepareStatement("alter table Complaints auto_increment=10000");
			createComplaints.execute();
			System.out.println("Tables created Successfully....");
			
		} catch (Exception e) {
			System.out.println("Some tables are already created or database already present first delete to create");
		}

	}

}
