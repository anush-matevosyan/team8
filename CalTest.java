
public class CalTest{
	public static void main(String[] args){
		Calendar year = new Calendar(2025);
		Calendar month = new Calendar(2024, 05);
		Calendar month2 = new Calendar(2024, 12);
		Calendar day = new Calendar(2023, 02, 16);
		Calendar day2 = new Calendar(2023, 02, 05);
		
		System.out.println(year.calc());
		System.out.println(month.calc());
		System.out.println(month2.calc());
		System.out.println(day.calc());
		System.out.println(day2.calc());
	}
}	