import java.util.ArrayList;
import java.util.*;

public class Main {
	
	public static VisitingStudent Person1() { 
		VisitingStudent a = new VisitingStudent("Catherine");
		
		a.enroll(101, 2, 1400, 1600, 3);
		a.enroll(102, 2, 1601, 1700, 3);
		a.enroll(500, 3, 1700, 1900, 2);
		return a;
	}

	public static Student createPerson2() {
		Student s = new Student("Mary");
		
		s.enroll(101, 2, 1400, 1600, 3);
		s.enroll(102, 2, 1601, 1700, 3);
		s.enroll(500, 3, 200, 400, 2);
		return s;
	}
	
	public static Student createPerson3() {
		Student s = new Student("Jane");
		s.enroll(101, 2, 1400, 1600, 3);
		
		// COLLIDE WITH 101 SCHEDULE!
		try {
			s.enroll(232, 2, 1400, 1600, 1);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		s.enroll(102, 2, 1601, 1800, 3);
		s.enroll(200, 1, 1400, 1600, 2);
		
		// INVALID DAY 0!
		try {
			s.enroll(201, 0, 0000, 2000, 1);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		// OVER MAX CREDITS!
		try {
			s.enroll(405, 5, 1200, 1400, 2);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		s.enroll(200, 5, 1400, 1600, 1);
		
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student catherine = createPerson2();
		Student cat1= createPerson3();
		VisitingStudent cat2 = Person1();
	
		//Array to hold number of courses ( add courses) 
		ArrayList <Student> students= new ArrayList<Student>();
		students.add(catherine);
		students.add(cat1);
		students.add(cat2);

		
		System.out.println("\nSchedules: \n ");
		for (Student student : students) {
			System.out.println(student.getName());
			student.printschedule();
			System.out.println("");
		}
	}
 
}
