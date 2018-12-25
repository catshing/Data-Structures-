public class Course {

	int coursenum;
	int start;
	int end;
	int day;
	String weekString;
	int credits;

	public Course(int coursenum_, int start_, int end_, int day_, int credits_) {
		this.coursenum = coursenum_;
		this.start = start_;
		this.end = end_;
		this.day = day_;
		this.credits = credits_;
		this.weekString = getWeekString(day_);
	}

	private String getWeekString(int day_) {
		switch(day_) {
		case 1: 
			return "Mondays";
		case 2: 
			return "Tuesdays";
		case 3: 
			return "Wednesdays";
		case 4: 
			return "Thursday";
		case 5: 
			return "Friday";
		default: 
			throw new NullPointerException("Invalid day " + day_ + " for course " + coursenum + ".");
		}
	}

	public String toMilitary() { 
		return String.format("%04d-%04d", start, end);
	}

	public String toTwelveHour(int time) {
		String am_pm = (time >= 0 && time < 1200) ? "AM" : "PM";
		if (time > 1200) {
			time -= 1200;
		}
		return Integer.toString(time) + am_pm;
	}

	public String toString() {
		return String.format("%s-%s", toTwelveHour(start), toTwelveHour(end));
	}

}
