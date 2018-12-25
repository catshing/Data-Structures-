package HW1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
	
	public static String file_template = "src/HW1/hw1_set%d.txt";

	public static void main(String[] args) throws FileNotFoundException {
		StudentReader input_reader = new StudentReader();
		Schedule schedule;
		String input, cur_filename;
		ArrayList<Student> students = new ArrayList<Student>();
		TutorSession[] topThree;
		
		for (int i=1; i<=5; ++i) {
			cur_filename = String.format(file_template, i);
			schedule = new Schedule(5);
			try {
				input_reader.readInput(cur_filename);
			} catch (ParseException e) {
				System.out.println("- Parsing Error on file " + cur_filename);
				System.out.println("");
				continue;
			}
			input = input_reader.getInput();
			
			students = StudentReader.getStudents(input);
			for (Student student : students) {
				schedule.insertStudent(student);
			}
			
			topThree = schedule.getTopThree();
			System.out.println("+ Top three schedules in " + cur_filename);
			for (TutorSession tmp : topThree) {
				System.out.println("Day: " + tmp.day +  "\t\tTime: " + tmp.time + "\t# students: " + tmp.student_size);
			}
			System.out.println("");
		}
		
	}

}
