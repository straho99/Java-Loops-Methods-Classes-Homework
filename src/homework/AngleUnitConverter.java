package homework;

import java.util.Scanner;

public class AngleUnitConverter {

	public static void main(String[] args) {
		// Problem 05:
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		input.nextLine();
		double[] values=new double[n];
		String[] types=new String[n];
		for (int i = 0; i < n; i++) {
			String line=input.nextLine();
			String[] splittedLine=line.split(" ");
			values[i]=Double.valueOf(splittedLine[0]);
			types[i]=splittedLine[1];
		}
		
		for (int i = 0; i < n; i++) {
			if (types[i].equals("deg")) {
				System.out.printf("%f rad\n", DegreesToRadians(values[i]));
			}
			else {
				System.out.printf("%f deg\n", RadiansToDegrees(values[i]));
			}
		}

	}

	public static double DegreesToRadians(double degrees){
		double result=0.0;
		result=(degrees * Math.PI)/180;
		return result;
	}
	
	public static double RadiansToDegrees(double radians){
		double result=0.0;
		result=(radians * 180) / Math.PI;
		return result;
	}
}
