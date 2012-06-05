package de.fhh.pr2.jhass.u.b3;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarMain {
	public static void main(String[] args) {
		Calendar localCal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"),
												 new Locale("de", "DE"));
		Calendar budCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Bangkok"),
											   new Locale("th", "TH"));
		localCal.set(2009, 11, 24, 10, 30);
		budCal.setTime(localCal.getTime());
		DateFormat df = DateFormat.getInstance();
		df.setCalendar(budCal);
		System.out.println(df.format(budCal.getTime()));
	}
}
	