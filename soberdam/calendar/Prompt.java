package soberdam.calendar;

import java.util.Scanner;

public class Prompt {
	private final static String PROMPT = "cal>";
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;

		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();

			if (month == -1) {
				break;
			} else if (month > 12) {
				continue;
			}

			cal.printCalendar(2023, month);

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
