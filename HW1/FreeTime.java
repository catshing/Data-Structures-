package HW1;

import java.util.ArrayList;

public class FreeTime {
	
	public ArrayList<Integer> times;
	public char day;
	
	public FreeTime(char day_) {
		this.day = Character.toUpperCase(day_);
		this.times = new ArrayList<Integer>();
	}
	
	public void addTime(int time) {
		this.times.add(time);
	}
	
	public void addTimes(ArrayList<Integer> times) {
		for (Integer time : times) {
			addTime(time);
		}
	}
	
	public ArrayList<Integer> getTimes() {
		return this.times;
	}

}
