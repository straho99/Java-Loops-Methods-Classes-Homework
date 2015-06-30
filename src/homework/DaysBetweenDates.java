package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DaysBetweenDates {

	public static void main(String[] args) throws ParseException {
		// Problem 7:
		Scanner input=new Scanner(System.in);
		String startDate=input.nextLine();
		String endDate=input.nextLine();
		   
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" );   
		Calendar start = Calendar.getInstance();    
		start.setTime(dateFormat.parse(startDate));
		Calendar end = Calendar.getInstance();    
		end.setTime(dateFormat.parse(endDate));
		int countOfDays=0;
		while (start.getTime().before(end.getTime())) {
			start.add( Calendar.DATE, 1 );
			countOfDays++;
		}
		while (end.getTime().before(start.getTime())) {
			end.add( Calendar.DATE, 1 );
			countOfDays--;
		}
		System.out.println(countOfDays);
	}

}
