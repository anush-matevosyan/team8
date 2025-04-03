package team8;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WritingDriver{
	Writing write;
	Writing goal;
	Writing category;
	
    @Before
	public void setUp() throws Exception {
        write = new Writing("spendings.csv");
		goal = new Writing("savingsGoal.txt");
		category = new Writing("category.txt");
    }
	
	@Test
	public void testAddData(){
		write.addData("2025/05/01", "15.00", "Clothes", "bought a jacket");
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
		double amount = 500;
		goal.saveSavingsGoal(amount);
		
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
	public void testLoadSavingsGoal(){
		double get = goal.loadSavingsGoal();
		Assert.assertEquals(500.0, get);
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
