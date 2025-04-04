package team8;

import java.io.FileWriter;
import java.io.IOException;

public class TxtWriting implements WritingData{
	private String fileName;

	public TxtWriting(String nameIn) {
			fileName = nameIn;
	}
	
	@Override
	public void writingData(String[] data) {
		try{
			FileWriter file;
			file = new FileWriter(fileName);
			file.append("Saving goal:\n" + data[0] + "\n");
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	
	public static void addCategory(String fileName, String catIn){
		try{
			FileWriter file;
			file = new FileWriter(fileName, true);
		
			file.append(catIn + "\n");
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}

}