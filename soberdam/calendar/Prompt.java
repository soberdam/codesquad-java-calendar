package soberdam.calendar;


import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");

	}

	public void runPrompt() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		printMenu();
		boolean is_Loop = true;
		while (is_Loop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch(cmd) {
			case "1": 
				cmdRegister(scanner, cal);
				break;
			case "2": 
				cmdSearch(scanner, cal);
				break;
			case "3": 
				cmdCal(scanner, cal);
				break;
			case "h": 
				printMenu();
				break;
			case "q": 
				is_Loop = false;
				break;
			}
			
		}
		System.out.println("Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner scanner, Calendar cal) {
		int month = 0;
		int year = 0;

		while (true) {
			System.out.println("연도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				return;
			}

			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			if (month < 1 || month > 12) {
				System.out.println("잘못된 입력입니다.");
				return;
			}

			cal.printCalendar(year, month);

		}
	}

	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = scanner.next();
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch(ParseException e) {
			e.printStackTrace();
			System.err .println("일정 검색중 오류가 발생했습니다.");
		}
		System.out.println(plan);
		
	}

	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd)");
		String date = scanner.next();
		scanner.nextLine();
		System.out.println("일정을 입력해 주세요.");
		String text = scanner.nextLine();
		
		cal.registerPlan(date, text);
		
	}

	public static void main(String[] args) throws ParseException {

		// 셸 실행
		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}

}
