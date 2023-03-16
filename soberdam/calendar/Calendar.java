package soberdam.calendar;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] WEEKDAYS = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
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

	public void printCalendar(int year, int month, String weekday) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("----------------------");
		int maxDay = getMaxDaysOfMonth(year, month);
		int weekIndex = 0;
		for(int i=0; i<WEEKDAYS.length; i++) {
			if(WEEKDAYS[i].equals(weekday)) {
				weekIndex = i;
			}
		}
		
		System.out.print(" ".repeat(weekIndex*3));
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			
			if ((i+weekIndex) % 7 == 0 || i == (7-weekIndex)) {
				System.out.println();
			}
		}
		System.out.println();

	}

}
