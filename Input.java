public class Input{
	String category;
	double amount;
	String notes;
	Calendar date;
	
	public Input(String catIn, double amountIn, String notesIn, Calendar dateIn){
		category = catIn;
		amount = amountIn;
		notes = notesIn;
		date = dateIn;
	}
	
	public Input(String catIn, double amountIn, Calendar dateIn){
		category = catIn;
		amount = amountIn;
		notes = null;
		date = dateIn; //figure out how date will be stores
	}
	
	public String toString(){
		if(notes != null){
			return "Category: " + category + " Amount: $" + amount +"Notes: " + notes + " Date: " + date;
		}
		return "Category: " + category + " Amount: $" + amount + " Date: " + date;
	}	
}
