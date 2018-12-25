package HW1;

import java.util.ArrayList;

public class Student {
	
	public String name;
	protected ArrayList<FreeTime> free_times;
	
	public Student(String name_) {
		this.name = name_;
		this.free_times = new ArrayList<FreeTime>();
	}
	
	public void addFreeTime(FreeTime freetime) {
		this.free_times.add(freetime);
	}
	
	public void addFreeSession(ArrayList<FreeTime> courses) {
		for (FreeTime course : courses) {
			addFreeTime(course);
		}
	}
	
	public ArrayList<FreeTime> getFreeTimes(){
		return this.free_times;
	}

}
