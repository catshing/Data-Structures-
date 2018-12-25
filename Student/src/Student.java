import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Student {   //Attributes 
	protected String name;
	protected int studentID;	
	protected int coursenum;
	protected int total_credits;
	protected int credits;
	protected int max_credit = 9;
	protected int start;
	protected int end;
	protected ArrayList<Course> courses;

	//Getters and setters of Student name and studentID
	public Student(String name_) {
		courses = new ArrayList<Course>();
		name = name_;
		total_credits = 0;
	}

	public String getName() { 
		return name;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) { 
		this.studentID = studentID;
	}

	public void sendNYUClassesemail() { 
		System.out.println("Sent NYU Classes Email to" + name);
	}
	
	private boolean isCollide(int day, int start, int end) {
		for (Course course : this.courses)
			if (day == course.day)
				if (start >= course.start && start <= course.end //
					|| end >= course.start && end <= course.end)
						return true;
			
		return false;
	}

	public void enroll(int coursenum_, int day_, int start_, int end_, int credit_ ) throws NullPointerException { 
		this.coursenum = coursenum_;
		this.credits = credit_;
		this.start = start_;
		this.end = end_;
		
		Course course = new Course(coursenum_, start_, end_, day_, credit_);

		if (isCollide(day_, start_, end_)) {
			throw new NullPointerException(this.name + " could not add course " + coursenum_ + "! Course collision ");
		} else if (this.total_credits + credit_ > this.max_credit) {
			throw new NullPointerException(this.name + " could not add course " + coursenum + " with " + credit_ + " credits!. Total credits: " + this.total_credits + ". Max: " + max_credit);
		}
				
		this.courses.add(course);
		total_credits += credit_; 
	}

	public void printschedule() {
		for (Course course : this.courses) {
			System.out.println("Enroll in class " + course.coursenum + " on " + course.weekString + " " +
		+ course.start + "-" + (course.end) +  ", " +  course.credits +  " credit course");
		}
	}

}


