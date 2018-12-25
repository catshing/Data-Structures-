
public class Tutor implements Employee {
	
	int EmployeeID;
	
	public int getID() { 
		return EmployeeID;
	}
	public void setID(int EmployeeID) { 
		this.EmployeeID = EmployeeID;
	}
	
	public void sendNYUClassesemail() { 
		System.out.println("Sent NYU Email to" + this.EmployeeID);
	}
}

