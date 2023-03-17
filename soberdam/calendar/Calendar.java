package soberdam.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE = "calendar.dat";
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if (!f.exists()) {
			System.err.println("no save file");
			return;
		}
		try {
			Scanner scanner = new Scanner(f);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1];
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			scanner.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		}
		return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year) == true) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public int getWeekday(int year, int month) {

		int firstWeekday = 0; // 0년 1월 1일의 요일 = 일요일
		int weekday = 0; // month의 1일의 요일

		for (int i = 0; i < year; i++) {
			if (isLeapYear(year) == true) {
				firstWeekday = (firstWeekday + 2) % 7;
			} else {
				firstWeekday = (firstWeekday + 1) % 7;
			} // year의 1월 1일 요일 구하기
		}

		weekday = firstWeekday;
		for (int i = 1; i < month; i++) {
			weekday = (weekday + (getMaxDaysOfMonth(year, i) % 7)) % 7;
		} // month의 1일 요일 구하기

		return weekday;
	}

	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);

		File savefile = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(savefile, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}

	public void printCalendar(int year, int month) {
		System.out.printf("   <<%d년 %d월>>\n", year, month);
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int maxDay = getMaxDaysOfMonth(year, month); // month의 일수
		int weekday = getWeekday(year, month); // month의 1일 요일

		System.out.print("   ".repeat(weekday));
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);

			if ((i + weekday) % 7 == 0 || i == (7 - weekday)) {
				System.out.println();
			}
		}
		System.out.println();
		// 달력 출력
	}

}
