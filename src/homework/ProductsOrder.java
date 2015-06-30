package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductsOrder {

	public static void main(String[] args) {
		// Problem 10:
		String fileProducts = "products.txt";
		String fileOrders="order.txt";
		ArrayList<Product> products=new ArrayList<Product>();
		BigDecimal orderTotal=new BigDecimal(0);
		
		try(
			BufferedReader productsReader = new BufferedReader(
				new FileReader(fileProducts));
				BufferedReader ordersReader = new BufferedReader(
						new FileReader(fileOrders));
				PrintStream fileOutput = new PrintStream("output.txt", "UTF-8");
		) {
			//first, read the products:
			while (true) {
				String line = productsReader.readLine();
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
			//second, read the order, line by line and update the orderTotal on the fly:
			while(true){
				String line = ordersReader.readLine();
				if (line == null) {
					// End of file is reached
					break;
				}
				else {
					String[] splitLine=line.split(" ");
					BigDecimal quantity=BigDecimal.valueOf(Double.parseDouble(splitLine[0]));
					BigDecimal price=new BigDecimal(0);
					for (int i = 0; i < products.size(); i++) {
						if (products.get(i).getName().equals(splitLine[1])) {
							price=BigDecimal.valueOf(products.get(i).getPrice());
							break;
						}
					}
					orderTotal=orderTotal.add(quantity.multiply(price));
				}
			}
			//at the end, write to file (and to console for faster debugging):
			System.out.printf("%.2f", orderTotal);
			fileOutput.println(orderTotal);
		
		} catch (IOException ioex) {
			System.out.println("Error");;
		}

	}

}
