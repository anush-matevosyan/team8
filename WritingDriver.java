import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WritingDriver{
	CSVWriting write;
	TxtWriting goal;
	TxtWriting category;
	
    @Before
	public void setUp() throws Exception {
        write = new CSVWriting("spendings.csv");
		goal = new TxtWriting("savingsGoal.txt");
		category = new TxtWriting("category.txt");
    }
	
	@Test
	public void testAddData(){
		String[] data = {"2025/05/01", "15.00", "Clothes", "bought a jacket"};
		write.writingData(data);
		boolean exists = true;
		try{
			File file = new File("spendings.csv");
			//ArrayList<String> notes = new ArrayList<>();
			int row = 0;
			Scanner reader = new Scanner(file);
			String header = "Date, Amount, Category, Notes";
			String read = "2025-05-01,15.00,Clothes,bought a jacket,";
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				if(row ==0){
					Assert.assertEquals(header, line);
				}
				else{
					Assert.assertEquals(read, line);
				}
				row++;
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			exists = false;
			System.out.println("here");
		}
		Assert.assertEquals(exists, true);
		
			
	}
	
	@Test
	public void testSaveSavingsGoal(){
		String[] amount = new String[1];
		amount[0] = "500";
		goal.writingData(amount);
		
		boolean exists = true;
		try{
			File file = new File("savingsGoal.txt");
			//ArrayList<String> notes = new ArrayList<>();
			int rows = 0;
			Scanner reader = new Scanner(file);
			String header = "Saving goal:";
			String read = "100.0";
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				if(row ==0){
					Assert.assertEquals(header, line);
				}
				else{
					Assert.assertEquals(read, line);
				}
				rows++;
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			exists = false;
			System.out.println("here");
		}
		Assert.assertEquals(exists, true);
		
		
		
	}
	
	
	@Test
	public void testAddCategory(){
		category.addCategory("newCategory");
		boolean exists = true;
		try{
			File file = new File("category.txt");
			int rows = 0;
			Scanner reader = new Scanner(file);
			//String header = "Saving goal:";
			String read = "newCategory";
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				if(line.equals(read)){
					Assert.assertEquals(read, line);
				}
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			exists = false;
		}
		Assert.assertEquals(exists, true);	
	}
	
}

