import java.io.*;
import java.util.*;

public class Writing{
	private String fileName;
	
	public Writing(String fileNameIn){
		fileName = fileNameIn;
	}
	
	public double loadSavingsGoal(){
		double goal =0;
		try{
			File file = new File(fileName);
			ArrayList<String> goals = new ArrayList<>();
			Scanner reader = new Scanner(file);
			reader.nextLine();//get rid of header
			while(reader.hasNext()){
				goal = reader.nextDouble();
				reader.nextLine();
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("here");
			return -1;
		}
		catch(InputMismatchException e){
			System.out.println("no savings gola");
			return 0;
		}
		return goal;
	}
	
	public void saveSavingsGoal(double goal){
		try{
			FileWriter file;
			file = new FileWriter(fileName);
			file.append("Saving goal:\n" + goal + "\n");
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
		
	
	public void addData(String dateIn, String amountIn, String categoryIn, String notesIn){
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
		
			file.append(dateIn + ",");
			file.append(amountIn + ",");
			file.append(categoryIn + ",");
			file.append(notesIn + ",\n");
			
			file.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		
	}
}
