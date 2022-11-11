package useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exceptions.complainException;
import Exceptions.employeeException;
import Exceptions.engineerException;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Complaints;
import model.Employee;

public class EmployeeUseCase {

	public static void main(String[] args) throws engineerException,complainException,employeeException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Employee Department of Hardware/Software Support System.");
		EmployeeDao dao = new EmployeeDaoImpl();
		Complaints complaint = null;
		Employee employee=null;
		List<Complaints> complainList = new ArrayList<>();
		while(true) {
		System.out.println("Press 1 for Registration as Employee");
		System.out.println("Press 2 for Login as Employee");
		int val=sc.nextInt();
		if(val==1) {
			System.out.println("Enter Your First Name : ");
			String empFirstName=sc.next();
			System.out.println("Enter Your Last Name : ");
			String empLastName=sc.next();
			System.out.println("Enter Your City Name : ");
			String empCity=sc.next();
			System.out.println("Enter Your Salary : ");
			int salary=sc.nextInt();
			System.out.println("Enter Your Email : ");
			String empEmail=sc.next();
			System.out.println("Enter Your Password : ");
			String empPassword=sc.next();
			try {
				employee=new Employee(empFirstName, empLastName, empCity, salary, empEmail, empPassword);
				String check = dao.registerEmployee(employee);
				System.out.println(check);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println();
		}else if(val==2) {
			System.out.println();
			System.out.println("Enter the username");
			String email=sc.next();
			System.out.println("Enter the password");
			String password=sc.next();
			try {
				employee = dao.login(email, password);
				if(employee!=null) {
					System.out.println("Login Successful....");
					System.out.println();
					break;
				}else {
					System.out.println("Invalid UserNam/Password....");
				}
			} catch (employeeException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}else {
			continue;
		}
		}
		while(employee!=null) {
			System.out.println("Press 1 To Register Complaint");
			System.out.println("Press 2 To Get Complaint Detail");
			System.out.println("Press 3 To All Complaint Details");
			System.out.println("Press 4 To Change the password");
			System.out.println("Press 5 To Exit");
			List<Complaints> list = new ArrayList<>();
			int val = sc.nextInt();
			if(val==1) {
				
					System.out.println("Press 1 for Hardware Type Complaint \n Press 2 for Software Type Complaint");
					int x = sc.nextInt();
					String type="";
					if(x==1) {
						type="Hardware";
					}else if(x==2) {
						type="Software";
					}else {
						System.out.println("Invalid Input");
						System.out.println();
						continue;
					}
					 try {
					String check = dao.registerComplain(type, employee.getEmpId(), "Not Assigned");
					System.out.println(check);
				} catch (complainException e) {
					System.out.println(e.getMessage());
				}
				 System.out.println();
			}else if(val==2) {
				System.out.println("Enter the complainId to get details : ");
				int complainId = sc.nextInt();
				try {
					complaint=dao.getComplainDetails(complainId, employee.getEmpId());
					System.out.println(complaint);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				 System.out.println();
			}else if(val==3) {
				try {
					complainList= dao.getAllComplains(employee.getEmpId());
					complainList.forEach(System.out::println);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==4) {
				System.out.println("Enter New Password to Change");
				String newPassword= sc.next();
				try {
					String changePassword = dao.changePassword(employee.getEmpEmail(), newPassword);
					System.out.println(changePassword);
				} catch (employeeException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==5) {
				System.out.println("Do You Want to Exit : (Y/N)");
				String exitVal=sc.next();
				if("y".equalsIgnoreCase(exitVal)) {
					System.out.println();
					break;
				}else {
					continue;
				}
			}else {
				continue;
			}
		}
		System.out.println("Thank You....");
		sc.close();
		
		

	}

}
