import java.io.*;
import java.util.*;

public class Writing{
	private String fileName;
	
	public Writing(String fileNameIn){
		fileName = fileNameIn;
	}
	
	public void addData(String date, String amount, String category, String notes){
		boolean exists = true; 
		try{
			File file = new File(fileName);
			ArrayList<String> notes = new ArrayList<>();
			int rows = 0;
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()){
				reader.nextLine();
				rows++;
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			exists = false;
			System.out.println("here");
		}
		try{
			FileWriter file;
			file = new FileWriter(fileName, true);
			if(!exists){
				
				file.append("Date, Amount, Category, Notes\n");
			}
		
			file.append(date + ",");
			file.append(amount + ",");
			file.append(category + ",");
			file.append(notes + ",\n");
			
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		
	}
}
