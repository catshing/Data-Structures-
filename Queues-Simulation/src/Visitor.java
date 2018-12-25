
public class Visitor {
	public String name;
	public String interest;
	 
	public Visitor(String inname, String ininterest) {
		name = inname;
		interest = ininterest;
	}
	
	public String toString() {
		return "Name: " + name + ", Interest: " + interest  ;
	}
	 

	@Override
	public boolean equals(Object inv) {
		Visitor v;
		v = (Visitor) inv;
		if ( v.interest == this.interest) { return true;}
		return false;
		 
	}
}
