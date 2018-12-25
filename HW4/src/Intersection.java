
import java.util.ArrayList;

public class Intersection {
	
	ArrayList<String> streets;
	protected boolean marked;
	
	public Intersection(String[] _s) {
		streets = new ArrayList<String>();
		for (String s : _s) {
			streets.add(s.toLowerCase());
		}
		marked = false;
	}
	
	public void mark() {
		this.marked = true;
	}
	
	public void unMark() {
		this.marked = false;
	}
	
	public boolean isMarked() {
		return this.marked;
	}
	
	public boolean equals(Intersection in) {
		if (in.streets.size() != this.streets.size()) {
			return false;
		}
		
		for (String s:this.streets) {
			if (!in.streets.contains(s))
				return false;
		}
		return true;
	}
	
	public boolean equals(String in) {
		String[] ins = in.split(",");
		if (this.streets.size() != ins.length)
			return false;
		
		for (String s:ins) {
			if (!this.streets.contains(s.toLowerCase()))
				return false;
		}

		return true;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (String st:this.streets) {
			s.append(st + ',');
		}
		
		String ret = s.toString();
		return ret.substring(0, s.length()-1);
	}
}
