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
			PreparedStatement createEmp = conn.prepareStatement("create table Employee(empId int primary key auto_increment,FirstName varchar(15),LastName varchar(15),city varchar(12),salary int,email varchar(20),password varchar(15))");
			createEmp.execute();
			createEmp = conn.prepareStatement("alter table Employee auto_increment=1000");
			createEmp.execute();
			PreparedStatement createEng = conn.prepareStatement("create table Engineer(EngineerId int primary key auto_increment,FirstName varchar(15),LastName varchar(15),city varchar(12),salary int,email varchar(20),password varchar(15))");
			createEng.execute();
			createEng = conn.prepareStatement("alter table Engineer auto_increment=450");
			createEng.execute();
			PreparedStatement createComplaints = conn.prepareStatement("create table Complaints(complainId int primary key auto_increment,EmployeeId int,EngineerId int,status varchar(12),"
					+ "foreign key(EmployeeId) references employee(empId),foreign key(EngineerId) references Engineer(EngineerId))");
			createComplaints.execute();
			createComplaints = conn.prepareStatement("alter table Complaints auto_increment=10000");
			createComplaints.execute();
			System.out.println("Tables created Successfully....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
