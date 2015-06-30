package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Sheet;

import com.smartxls.WorkBook;


public class excel3 {
//Това е решение на задачата със SmartXLS - външна библиотека за работа с екселски файлове.
//Размерът на библиотеката е само 3мб и няма проблем с размера на домашното.
	
	public static void main(String[] args) {
		// Problem 11:
		double grandTotal=0.0;
		//I will store the incomes per office in a dictionary of type TreeMap 
		//- it stores the keys in a sorted order. So, no need to sort them myself.
		Map<String, Double> offices= new TreeMap<String, Double>();
		//Open the file and read the data in the dictionary:
		try {
		    //Get the workbook: 
		    WorkBook incomesReport=new WorkBook();
		    incomesReport.readXLSX("Incomes-Report.xlsx");
		 
		    //Move to first sheet in the workbook
		    incomesReport.setSheet(0);
		    
		    //Iterate through each row from the first sheet that has a value in the first column:
		    int rowCounter=1;
		    while (incomesReport.getText(rowCounter, 0).length()>0) {
		    	//System.out.println(incomesReport.getText(rowCounter, 0));
		    	String officeName=incomesReport.getText(rowCounter, 0);
		    	Double officeIncome=Double.parseDouble(incomesReport.getText(rowCounter, 5));
		    	if (offices.containsKey(officeName)) {
					//if the office name exists, we add the new value to the old:
		    		offices.put(officeName, offices.get(officeName) + officeIncome);
				}
	            else {
	            	//if the office doesn't exist in the dictionary, we add it with value:
	            	offices.put(officeName, officeIncome);
				}
				rowCounter++;
			}
		    
		    for (Map.Entry<String,Double> entry : offices.entrySet()) {
		    	String key = entry.getKey();
		    	Double value = entry.getValue();
		    	String output=key + " Total -> " + value.doubleValue();
		    	System.out.println(output);
		    	grandTotal=grandTotal + value.doubleValue();
			}
		    System.out.println("Grand Total -> " + grandTotal);
		
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();
	}
	}
}
	
