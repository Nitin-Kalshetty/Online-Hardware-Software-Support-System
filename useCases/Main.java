package useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exceptions.complainException;
import Exceptions.employeeException;
import Exceptions.engineerException;
import Exceptions.hodException;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.EngineerDao;
import dao.EngineerDaoImpl;
import dao.HodDao;
import dao.HodDaoImpl;
import model.Complaints;
import model.Employee;
import model.Engineer;
import model.Hod;

public class Main {
	
	public static void funcA() {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("Welcome to Hardware/Software Support System : ");
		System.out.println("Press 1 for Head Of Department");
		System.out.println("Press 2 for Employee Department");
		System.out.println("Press 3 for Engineer Department");
		System.out.println("Press 4 to Exit");
		int department=sc.nextInt();
		if(department==1) {
		System.out.println("Welcome to Head of Department of Hardware/Software Support System.");
		HodDao dao=new HodDaoImpl();
		Hod hod= null;
		while(true) {
		System.out.println("Please First Login...");
		System.out.println();
		System.out.println("Enter the username");
		String email=sc.next();
		System.out.println("Enter the password");
		String password=sc.next();
			try {
				hod = dao.loginHOD(email, password);
				if(hod!=null) {
					System.out.println("Login Successful....");
					System.out.println();
					break;
				}
				
			} catch (hodException e) {
			System.out.println(e.getMessage());
			}
		System.out.println();
		}
		while(hod!=null) {
			System.out.println("Press 1 To RegisterNew Engineer");
			System.out.println("Press 2 To View All Registered Users");
			System.out.println("Press 3 To Delete the Engineer");
			System.out.println("Press 4 To View All Raised Complains");
			System.out.println("Press 5 To Assign the Complaint");
			System.out.println("Press 6 To Exit");
			List<Complaints> complaints = new ArrayList<>();
			List<Engineer> engineers = new ArrayList<>();
			int val = sc.nextInt();
			if(val==1) {
				System.out.println("Enter the Engineer First Name : ");
				String engFirstName=sc.next();
				System.out.println("Enter the Engineer Last Name : ");
				String engLastName=sc.next();
				System.out.println("Enter the Engineer City Name : ");
				String engCity=sc.next();
				System.out.println("Enter the Engineer Salary : ");
				int salary = sc.nextInt();
				System.out.println("Enter the Engineer Email Id : ");
				String emailId = sc.next();
				System.out.println("Enter the Engineer Password : ");
				String password = sc.next();
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
				Engineer engineer = new Engineer(engFirstName, engLastName, engCity, salary, emailId, password, type, hod.getHodId());
				try {
					String check = dao.registerNewEngineer(engineer);
					System.out.println(check);
				} catch (engineerException e) {
					System.out.println(e.getMessage());
				} catch (hodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==2) {
					try {
						engineers=dao.viewAllRegisteredEngineers(hod.getHodId());
						if(engineers.size()==0) {
							System.out.println("No engineers Registered..");
						}else {
							engineers.forEach(System.out::println);	
						}
					} catch (hodException e) {
						System.out.println(e.getMessage());
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
			}else if(val==3) {
				System.out.println("Enter the username of Engineer whom you want to delete : ");
				String username = sc.next();
				try {
					String check = dao.deleteEngineer(username,hod.getHodId());
					System.out.println(check);
				} catch (engineerException e) {
					System.out.println(e.getMessage());
				} catch (hodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==4) {
				try {
					complaints=dao.raisedProblems();
					complaints.forEach(System.out::println);
				} catch (complainException e) {
					System.out.println(e.getMessage());
				} catch (hodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else if(val==5) {
				System.out.println("Enter the EngineerId to Assign complaint : ");
				int engineerId = sc.nextInt();
				System.out.println("Enter the complainId : ");
				int complainId = sc.nextInt();
				try {
					String check = dao.assignProblem(engineerId, complainId,hod.getHodId());
					System.out.println(check);
				} catch (complainException e) {
					System.out.println(e.getMessage());
				} catch (hodException e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			}else {
				System.out.println("Do You Want to Exit : (Y/N)");
				String exitVal=sc.next();
				if("y".equalsIgnoreCase(exitVal)) {
					System.out.println();
					break;
				}else {
					continue;
				}
			}
		}
		}else if(department==2) {
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
		} else if(department==3) {
			System.out.println("Welcome to Engineer Department of Hardware/Software Support System.");
			EngineerDao dao=new EngineerDaoImpl();
			Engineer engineer = null;
			while(true) {
			System.out.println("Please First Login...");
			System.out.println();
			System.out.println("Enter the username");
			String email=sc.next();
			System.out.println("Enter the password");
			String password=sc.next();
			try {
				engineer = dao.engLogin(email, password);
				if(engineer!=null) {
					System.out.println("Login Successful....");
					System.out.println();
					break;
				}
				
			} catch (engineerException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
			}
			
			while(engineer!=null) {
				System.out.println("Press 1 for Engineer viewProblems");
				System.out.println("Press 2 for Updating The Status");
				System.out.println("Press 3 To View the attended Problems");
				System.out.println("Press 4 To Change the password");
				System.out.println("Press 5 To Exit");
				List<Complaints> list = new ArrayList<>();
				int val = sc.nextInt();
				if(val==1) {
					 try {
						list = dao.viewProblems(engineer);
						if(list.size()==0) {
							System.out.println("No problems assigned to You");
						}else {
							list.forEach(System.out::println);
						}
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					 System.out.println();
				}else if(val==2) {
					System.out.println("Enter the complainId to update Status");
					int complainId = sc.nextInt();
					System.out.print("To Change status \n press 1 for pending \n press 2 for completed");
					int statusV =sc.nextInt();
					String status ="";
					if(statusV==1) {
						status = "Pending";
					}else if(statusV==2){
						status ="Completed";
					}else {
						System.out.println("Invalid Input..");
						continue;
					}
					try {
						String check = dao.updateStatus(complainId, engineer, status);
						System.out.println(check);
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					 System.out.println();
				}else if(val==3) {
					try {
						list=dao.viewAttended(engineer);
						if(list.size()==0) {
							System.out.println("No problems attended");
						}else {
							list.forEach(System.out::println);
						}
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					
				}else if(val==4) {
					System.out.println("Enter New Password to Change");
					String newPassword= sc.next();
					try {
						String changePassword = dao.changePassword(engineer, newPassword);
						System.out.println(changePassword);
					} catch (engineerException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
				}else if(val==5) {
					break;
				}else {
					System.out.println("Do You Want to Exit : (Y/N)");
					String exitVal=sc.next();
					if("y".equalsIgnoreCase(exitVal)) {
						System.out.println();
						break;
					}else {
						continue;
					}
					
					
				}
			}
		}else {
			break;
		}
		
		}
		System.out.println("Thank You....");
		sc.close();
	}

	public static void main(String[] args) {
		
		funcA();
	}

}
