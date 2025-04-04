package team8;
import java.io.*;
import java.util.*;

public class CSVWriting implements WritingData{
	private String fileName;
	
	public CSVWriting(String nameIn) {
			fileName = nameIn;
	}
	
	@Override
	public void writingData(String[] data) {
		boolean exists = true; 
		try{
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()){
				reader.nextLine();
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			exists = false;
		}
		try{
			FileWriter file;
			file = new FileWriter(fileName, true);
			if(!exists){
				file.append("Date, Amount, Category, Notes\n");
			}
		
			file.append(data[0] + ",");
			file.append(data[1] + ",");
			file.append(data[2] + ",");
			file.append(data[3] + ",\n");
			
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}	
	}
	
}
