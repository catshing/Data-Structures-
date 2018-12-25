
public class Professor implements Employee {
	
	int StaffID;
	
	public int getID() { 
		return StaffID;
	}
	public void setID(int StaffID) { 
		this.StaffID = StaffID;
	}
	public void sendNYUClassesemail() {
		System.out.println("Send NYU Classes Email to" + this.StaffID);
	}
}
