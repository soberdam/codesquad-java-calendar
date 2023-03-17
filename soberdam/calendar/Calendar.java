package soberdam.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, String> planMap;

	public Calendar() {
		planMap = new HashMap<Date, String>();
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

	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
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
