import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;


public class DateFormatTranslation {
	
	static int parse(String abcd){
		
		return Integer.parseInt(abcd);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance(new Locale("en", "EN"));
		String myDate = "20121031";
		cal.set(Integer.parseInt(myDate.subSequence(0, 4)+""), Integer.parseInt(myDate.subSequence(5, 6)+""), Integer.parseInt(myDate.subSequence(7, 8)+""));
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//, Locale.UK);
		fmt.setCalendar(cal);
		System.out.println(fmt.format(new Date()));
		cal = Calendar.getInstance(new Locale("en", "TH"));
		cal.set(2012, 10, 1);
//		System.out.println();
		fmt.setCalendar(cal);
		System.out.println("Hello "+fmt.format(new Date(cal.getTimeInMillis())));//fmt.format(new Date()));
		GregorianCalendar greCal = new GregorianCalendar(TimeZone.getDefault(), Locale.US);
		System.out.println(greCal.getInstance().getTime());
		System.out.println(greCal.getInstance(Locale.JAPAN).getTime());
		String abcd = "1234";
		

	}

}
