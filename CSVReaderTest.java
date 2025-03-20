import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CSVReaderTest {

	@Test
	void read() {
		CSVReader csv = new CSVReader();
		csv.read("hannahChase.csv");
		
		fail("File not found");
	}

	@Test
	void summary(){
		CSVReader csv = new CSVReader();
		csv.summary("hannahChase.csv");

		fail("File not found")

}
