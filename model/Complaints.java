package model;

public class Complaints {
	
	private int complainId;
	private int employeeId;
	private int engineerId;
	private String status;
	private String type;
	public Complaints(int complainId, int employeeId,String type) {
		super();
		this.complainId = complainId;
		this.employeeId = employeeId;
		this.status = "Not Assigned";
		this.type=type;
	}
	
	public Complaints(int complainId, int employeeId, int engineerId) {
		this.complainId = complainId;
		this.employeeId = employeeId;
		this.engineerId = engineerId;
	}



	public Complaints(int complainId, int employeeId, int engineerId, String status,String type) {
		super();
		this.complainId = complainId;
		this.employeeId = employeeId;
		this.engineerId = engineerId;
		this.status = status;
		this.type=type;
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Complaints [complainId=" + complainId + ", employeeId=" + employeeId + ", engineerId=" + engineerId
				+ ", status=" + status + ", type=" + type + "]";
	}

	
	
	
	
}
