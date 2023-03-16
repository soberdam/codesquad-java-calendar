package soberdam.calendar;
import java.util.Scanner;
public class Calendar {
	public static void main(String[] args) {
		System.out.println("일  월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		
		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		
		System.out.println("달을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		
		int month = scanner.nextInt();
		int day = 0;
		switch(month) {
			case 2:
				day = 28;
				break;
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
		}
		
		System.out.println(month + "월은 " + day +"일까지 있습니다.");
		scanner.close();
	}
}
