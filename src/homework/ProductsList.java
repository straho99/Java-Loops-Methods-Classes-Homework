package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ProductsList {

	public static void main(String[] args) {
		// Problem 9:
		String fileName = "products.txt";
		ArrayList<Product> products=new ArrayList<Product>();
		
		try(
			BufferedReader fileReader = new BufferedReader(
				new FileReader(fileName));
				PrintStream fileOutput = new PrintStream("output.txt", "UTF-8");
		) {
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					// End of file is reached
					break;
				}
				else {
					String[] splitLine=line.split(" ");
					Product newProduct=new Product();
					newProduct.setName(splitLine[0]);
					newProduct.setPrice(Double.parseDouble(splitLine[1]));
					products.add(newProduct);
				}
			}
			Product[] sortedProducts=products.toArray(new Product[products.size()]);
			Arrays.sort(sortedProducts);
			for (Product product : sortedProducts) {
				System.out.println(product);
				fileOutput.println(product);
			}
		} catch (IOException ioex) {
			System.out.println("Error");
		}
		
	}

}
