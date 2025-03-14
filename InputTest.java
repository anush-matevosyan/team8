import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InputTest{
	//public static void main(String[] args){
	@Test
	void testConstructor() {
		Calendar date1 = new Calendar(2025, 03, 15);
		Input one = new Input("Food", 9, "bought a snack", date1);
		expected = "Category: " + "Food" + " Amount: $" + 9 +"Notes: " + "bought a snack" + " Date: " + date1;
		result = one.toString();
		assertEquals(expected, result);
	}
	
	@Test
	void testToString(){
		Calendar date2 = new Calendar(2024);
		Input two = new Input("Furniture", 1000, "bought a couch", date2);
		expected = "Category: " + "Furniture" + " Amount: $" + 1000 +"Notes: " + "bought a couch" + " Date: " + date2;
		result = one.toString();
		assertEquals(expected, result);
	//	}
	}
}