package soberdam.calendar;
import java.util.Scanner;
public class Sum {

	public static void main(String[] args) {
		//입력: 키보드로 두 수의 입력을 받는다.
		
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		//출력: 화면에 두 수의 합을 출력한다.
		
		System.out.printf("%d와 %d의 합은 %d입니다.", num1, num2, (num1+num2));
		scanner.close();
	}

}
