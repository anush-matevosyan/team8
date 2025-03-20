import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CSVReaderTest {

	@Test
	void read() {
		CSVReader csv = new CSVReader();
		csv.read("hannahChase.csv");
		
		fail("File not found");
	}

}
