package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SumNumbersFromFile {

	public static void main(String[] args) {
		// Problem 8:
		String fileName = "input.txt";
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		int sum=0;
		try(
			BufferedReader fileReader = new BufferedReader(
				new FileReader(fileName));
		) {
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					// End of file is reached
					break;
				}
				else {
					numbers.add(Integer.parseInt(line));
				}
				//System.out.println(line);
			}
			for (int i = 0; i < numbers.size(); i++) {
				sum=sum + numbers.get(i).intValue();
			}
			System.out.println(sum);
		} catch (IOException ioex) {
			System.out.println("Error");;
		}

	}

}
