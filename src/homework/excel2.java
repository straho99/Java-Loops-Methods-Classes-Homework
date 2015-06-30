package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excel2 {
//Това е решение на задачата с Apache POI - външна библиотека за работа с екселски файлове.
// Проблемът обаче е, че за да работи решението трябва да включа цели шест jar файла и цялото домашно става над 
//9мб. Демек, не мога да го кача в СофтУни.
//Поради това, тук е сорс кода, който за да работи трябва да се добавят следните файлове:
//dom4j-1.6.1.jar
//stax-api-1.0.1.jar
//xmlbeans-2.6.0.jar
//poi-3.10.1-20140818.jar
//poi-ooxml-3.10.1-20140818.jar
//poi-ooxml-schemas-3.10.1-20140818.jar
	
	public static void main(String[] args) {
		// Problem 11:
		double grandTotal=0.0;
		Map<String, Double> offices= new TreeMap<String, Double>();
		try {
		    FileInputStream file = new FileInputStream(new File("Incomes-Report.xlsx"));
		     
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0);
		     
		    //Iterate through each rows from first sheet
		    Iterator<Row> rowIterator = sheet.iterator();
		    
		    while(rowIterator.hasNext()) {
		    	Row row = rowIterator.next();
		    	if (row.getRowNum()==0) {
				continue;	
				}
	            Cell cell = row.getCell(0);
	            String officeName=cell.getStringCellValue();
	            cell=row.getCell(5);
	            Double officeIncome=new Double(cell.getNumericCellValue());
	            if (offices.containsKey(officeName)) {
					offices.put(officeName, offices.get(officeName) + officeIncome);
				}
	            else {
	            	offices.put(officeName, officeIncome);
				}
		    }
		    file.close();
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
		}

	}

}
