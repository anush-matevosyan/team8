package team8;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import team8.Before;

class CSVReaderTest {

	@Before
	public void setUp() throws Exception {
		CSVReader csv = new CSVReader();
    }
	
	@Test
	void read() {
		csv.read("hannahChase.csv");
		fail("File not found");
	}

	@Test
	void summary(){
		csv.summary("hannahChase.csv");

		fail("File not found");
	}
	
	@Test
	public void testLoadSavingsGoal(){
		double get = csv.loadSavingsGoal();
		Assert.assertEquals(500.0, get);
	}
	

}
