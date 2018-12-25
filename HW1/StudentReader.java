package HW1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.ParseException;

public class StudentReader {
	
	public String input;
	public static char[] open_delim = {'(', '<', '['};
	public static char[] close_delim = {')', '>', ']'};
	

	public StudentReader() {
		this.input = "";
	}

	public void readInput(String filename) throws FileNotFoundException, ParseException {
		// Filler. Get this stuff from file instead.
//		String input = "(Catherine<T[1200][1300]>)";
		
		File inputFile = new File(filename);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(inputFile);
		String input = "";
		
		while (scanner.hasNextLine()) { 
			input += scanner.nextLine();
		}
		
		if (!validate(input)) {
			throw new ParseException("Invalid input!", 0);
		}
		this.input = input;

	}
	
	public String getInput() {
		return this.input;
	}
	
	public static boolean isOpenDelim(char c) {
		for (char cur : open_delim) {
			if (c == cur) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isCloseDelim(char c) {
		for (char cur : close_delim) {
			if (c == cur) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isMatchingDelims(char open_delim, char close_delim) {
		switch(close_delim) {
		case ')':
			if (open_delim == '(')
				return true;
			break;
		case ']':
			if (open_delim == '[')
				return true;
			break;
		case '>':
			if (open_delim == '<')
				return true;
			break;
		}
		
		return false;
	}
	
	public boolean validate(String input) {
		char c;
		ArrayList<Character> stack = new ArrayList<Character>();
		
		for (int i=0; i < input.length(); ++i) {
			c = input.charAt(i);
			// Just push it
			if (isOpenDelim(c)) {
				stack.add(c);
			} else if (isCloseDelim(c)) {
				int last_index = stack.size() - 1;
				
				// Stack is empty, non match for closing brace
				if (last_index == -1)
					return false;
				
				// If closing brace doesn't match top of stack
				if (!isMatchingDelims(stack.get(last_index), c))
					return false;
				stack.remove(last_index);
			}
			
		}
		
		// End of String
		if (stack.size() != 0)
			return false;
		
		return true;
	}
	
	public static ArrayList<Integer> getTimes(String s) {
		char ch;
		ArrayList<Integer> times = new ArrayList<Integer>();
		boolean getTime = false;
		String time = "";
		
		for (int i=0; i<s.length(); ++i) {
			ch = s.charAt(i);
			
			if (ch == '[')
				getTime = true;
			else if (ch == ']') {
				times.add(Integer.parseInt(time));
				time = "";
				getTime = false;
			} else if (ch == '>') {
				break;
			}			
			else if (getTime) {
				time += ch;
			}
		}
		
		return times;
	}
	
	public static ArrayList<FreeTime> getFreeTimes(String s) {
		ArrayList<FreeTime> freetimes = new ArrayList<FreeTime>();
		ArrayList<Integer> times = new ArrayList<Integer>();
		FreeTime freetime = null;
		char ch;
		char day = 0;
		boolean getDay = false;
		int i = 0;

		while (i < s.length()) {
			ch = s.charAt(i);
			
			if (ch == '<')
				getDay = true;
			else if (ch == '[') {
				getDay = false;
				freetime = new FreeTime(day);
				times = getTimes(s.substring(i));
				freetime.addTimes(times);
				while (true) {
					if (s.charAt(i) != '>')
						++i;
					else
						break;
				}
				continue;
			}
			else if (ch == '>') {
				freetimes.add(freetime);
				getDay = false;
			} else if (ch == ')') {
				break;
			} else if (getDay) {
				day = ch;
			}
			
			++i;
		}
		
		return freetimes;
	}
	
	public static ArrayList<Student> getStudents(String s) {
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<FreeTime> freetimes = new ArrayList<FreeTime>();
		Student cur_student = null;
		char ch;
		String name = "";
		boolean getName = false;
		int i = 0;

		while (i < s.length()) {
			ch = s.charAt(i);
			
			if (ch == '(')
				getName = true;
			else if (ch == '<') {
				getName = false;
				cur_student = new Student(name);
				freetimes = getFreeTimes(s.substring(i));
				cur_student.addFreeSession(freetimes);
				while (true) {
					if (s.charAt(i) != ')')
						++i;
					else
						break;
				}
				continue;
			}
			else if (ch == ')') {
				students.add(cur_student);
				name = "";
				getName = false;
			} else if (getName) {
				name += ch;
			}
			
			++i;
		}
		
		return students;
	}

	public ArrayList<Student> parseInput() {
		// Parses (Catherine<T[900][1300]><H[1100][900]>)
		ArrayList<Student> students;	
		
		students = getStudents(this.input);
		
		return students;
	}

}
