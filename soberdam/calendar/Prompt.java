package soberdam.calendar;

import java.util.Scanner;

public class Prompt {
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 0;
		String weekday = "";

		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
			System.out.print("WEEKDAY> ");
			weekday = scanner.next();
			
			if (month == -1) {
				break;
			} else if (month > 12) {
				continue;
			}

			cal.printCalendar(year, month, weekday);

		}

		System.out.println("Bye~");
		scanner.close();
	}
	
	public static void main(String[] args) {

		//셸 실행
		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}

}
