package soberdam.calendar;
import java.util.Scanner;
public class Calendar {
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth(int month) {
		
		return MAX_DAYS[month-1];
	}
	
	public void printSampleCalendar28() {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public void printSampleCalendar30() {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println("29 30");
	}
	
	public void printSampleCalendar31() {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println("29 30 31");
	}
	
	public static void main(String[] args) {
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		
		String PROMPT = "cal>";
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		
		int month = 0;
		
		while(true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			
			if(month == -1) {
				break;
			} else if (month > 12) {
				continue;
			}
			
			int maxDay = cal.getMaxDaysOfMonth(month);
			if(maxDay == 31) {
				cal.printSampleCalendar31();
			}else if(maxDay == 30) {
				cal.printSampleCalendar30();
			}else {
				cal.printSampleCalendar28();
			}
			
		}
		
		System.out.println("Bye~");
		scanner.close();
	}
}
