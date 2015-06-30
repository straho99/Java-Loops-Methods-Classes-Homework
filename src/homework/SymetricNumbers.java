package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SymetricNumbers {

	public static void main(String[] args) {
		// Problem 01:
		Scanner input=new Scanner(System.in);
		int start=input.nextInt();
		int end=input.nextInt();
		List<String> results=new ArrayList<String>();
		for (int i = start; i <= end; i++) {
			String strNumber=String.valueOf(i);
			if (strNumber.length()==1) {
				results.add(strNumber);
			}
			else if (strNumber.length()==2) {
				if (strNumber.charAt(0)==strNumber.charAt(1)) {
					results.add(strNumber);
				}
			}
			else {
				if (strNumber.charAt(0)==strNumber.charAt(2)) {
					results.add(strNumber);
				}
			}
		}
		System.out.println(results);
	}
}
