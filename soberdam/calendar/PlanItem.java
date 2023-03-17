package soberdam.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	private Date planDate;
	private String detail;
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String peoples = "";
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}

	public PlanItem(String date, String detail) {
		this.planDate = getDatefromString(date);
		this.detail = detail;
	}
	
	public void addPeople(String name) {
		peoples += name + ",";
	}
	
	public Date getDate() {
		return planDate;
	}
}
