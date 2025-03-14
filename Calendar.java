//called by the gui to calculate the date range of the report the user wants to see
public class Calendar{
	int day;
	int month;
	int year;
	
	public Calendar(int yearIn){
		year = yearIn; //need to figure out the format the excel stores stuff
		month = 0;
		day = 0;
	}
	
	public Calendar(int yearIn, int monthIn){
		year = yearIn; //need to figure out the format the excel stores stuff
		month = monthIn; //again 
		day = 0;
	}
	
	public Calendar(int yearIn, int monthIn, int dayIn){
		year = yearIn;//need to figure out the format the excel stores stuff
		month = monthIn;//again
		day = dayIn;
	}

	public int calc(){
		int date = year*10000 +  month * 100 + day;
		return date; //20050501
	}	
}
