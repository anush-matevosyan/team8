import java.io.File;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class CSVManager {

	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet spendings = workbook.createSheet("spendings");
		
		XSSFSheet income = workbook.createSheet("income");
		
		Map<String, Object[]> dataSpend = new TreeMap<String, Object[]>(); 
		
		Map<String, Object[]> dataIncome = new TreeMap<String, Object[]>(); 
		
		dataSpend.put("1", new Object[] {"Date", "Amount", "Category", "Notes"});
		//get the data from the GUI, hard coded for now
		dataSpend.put("2", new Object[] {"12/15/2024", "$20", "Food", "Treat"});
		dataSpend.put("3", new Object[] {"03/12/2025", "$500", "Bills", "Rent"});
		dataSpend.put("4", new Object[] {"03/13/2025", "$200", "Food", "Groceries"});
		
		dataIncome.put("1", new Object[] {"Date", "Amount Earned"});
		dataIncome.put("2", new Object[] {"02/28/2025", "$190"});
		
		Set<String> keyset = dataSpend.keySet();
		
		Set<String> keyset2 = dataIncome.keySet();
		
		int rownum = 0;
		
		ArrayList<String> keyList = new ArrayList<>(dataSpend.keySet());
		
		ArrayList<String> keyListIncome = new ArrayList<>(dataIncome.keySet());
		
		//writing into spendings
		for (int i = 0; i < keyList.size(); i++) {
			String key = keyList.get(i);
			Row row = spendings.createRow(i);

			Object[] objArr = dataSpend.get(key);
			int cellnum = 0;

			for (int j = 0; j < objArr.length; j++) {
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue((String) objArr[j]);
			}
		}
		//writing into income
		for (int i = 0; i < keyListIncome.size(); i++) {
			String key = keyListIncome.get(i);
			Row row = income.createRow(i);  

			Object[] objArr = dataIncome.get(key);
			int cellnum = 0;

			for (int j = 0; j < objArr.length; j++) {
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue((String) objArr[j]);
			}
		}
		
		try{
			/**
			from the gui ask the user if they have used the application before.
			if yes then open an existing workbook
			if no, create a new one 
			**/			
			boolean exists = true; //info from gui, hard coded for now
			String name = "Tom";
			String lastName = "Felton";		
			String fileName = name+lastName+".xlsx";
			FileOutputStream out;
			if (!exists){
				File f1 = new File(fileName);
				out = new FileOutputStream(f1);
			}
			else{
				out = new FileOutputStream(fileName);
			}
			
			workbook.write(out);
			
			out.close();
			
			System.out.println("\n" + fileName + " written successfully");
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
