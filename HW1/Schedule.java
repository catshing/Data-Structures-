package HW1;

import java.util.ArrayList;

public class Schedule {
	protected ArrayList<Student>[][] schedule;

	public Schedule(int days) {
		schedule = new ArrayList[days][13];
		init_schedule();
	}

	private void init_schedule() {
		for (int i=0; i<schedule.length; ++i) {
			for (int j=0; j<schedule[0].length; ++j) {
				schedule[i][j] = new ArrayList<Student>();
			}
		}
	}

	private int convertDayToColumn(char day) {
		// Convert integer ('M' (Monday) is 0, etc which is the column in double array schedule)
		switch(day) {
		case 'M':
			return 0;
		case 'T':
			return 1;
		case 'W':
			return 2;
		case 'H':
			return 3;
		case 'F':
			return 4;
		default:
			return -1;
		}
	}
	
	private char convertColumnToDay(int column) {
		switch(column) {
		case 0:
			return 'M';
		case 1:
			return 'T';
		case 2:
			return 'W';
		case 3:
			return 'H';
		case 4:
			return 'F';		
		default:
			return '\0';
		}
	}
	
	public int convertTimeToRow(int time) {
		return (time/100) - 9;
	}

	public int convertRowToTime(int row) {
		return (row + 9)*100;
	}
	
	public void insertStudent(Student student) {
		ArrayList<FreeTime> freetimes = student.getFreeTimes();
		int row;
		int column;
		
		for (FreeTime freetime : freetimes) {
			row = convertDayToColumn(freetime.day);				// Get the day of the week
			ArrayList<Integer> times = freetime.getTimes();
			for (int time : times) {							// Insert student at each time of that day he/she is free
				column = convertTimeToRow(time);;
				schedule[row][column].add(student);
			}
		}

	}
	
	public TutorSession[] getTopThree() {
		TutorSession[] topThree = new TutorSession[3];
		int i, j, k;
		int max_day=0, max_time=0;
		int max=-1, cur;
		ArrayList<Student> tmp = null;
		
		for (k=0; k<3; ++k) {
			for (i=0; i<this.schedule.length; ++i) {
				for (j=0; j < this.schedule[0].length; ++j) {
					cur = this.schedule[i][j].size();
					if (cur > max) {
						max = cur;
						max_day = i;
						max_time = j;
						tmp = this.schedule[i][j];
					}
				}
			}
			topThree[k] = new TutorSession(convertColumnToDay(max_day), convertRowToTime(max_time), max);
			tmp.clear();
			max = -1;
		}
		return topThree;
	}

	public ArrayList<Student>[][] getSchedule() {
		return schedule;
	}
	

}
