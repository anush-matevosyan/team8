package team8;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVReader{
    public static void read(String fileName){
        //String fileName = "hannahChase.csv";
        File file = new File(fileName);
        List<List<String>> chart = new ArrayList<>();
        Scanner scanner;
           
        try{
            scanner = new Scanner(file);
            scanner.next();//header
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] value = row.split(",|\n");
                chart.add(Arrays.asList(value));
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        try{
            FileWriter writer = new FileWriter("TransactionHistory.txt");
            writer.write("Transaction History\n");
            writer.write("\nDate\t\tAmount\tCategory\tNotes\n");
        
            for(List<String> line : chart) {
                StringTokenizer tokenizer = new StringTokenizer(line.toString(), "[],");
                while(tokenizer.hasMoreTokens()) {
                    String str = tokenizer.nextToken();
                    writer.write(str);
                    writer.write("\t");
                }
                writer.write("\n");
            }
                
            writer.close();
        }catch(IOException e){
            System.out.println("IO Exception");
        }    
    }

    public static double summary(String fileName){
		double sum =0;
		try{
			File file = new File(fileName);
			ArrayList<String> data = new ArrayList<>();
			Scanner reader = new Scanner(file);
			reader.nextLine();//get rid of header
			while(reader.hasNextLine()){
				data.add(reader.nextLine());
			}
			for(int i=0; i<data.size(); i++){
				String[] line = data.get(i).split(",");
				sum += Double.parseDouble(line[1]);
				System.out.println(sum);
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("summary file not found");
			return -1;
		}
		return sum;
	}
	
	public static HashMap<String, Double> getCategoryExpenses(String fileName){
		//double sum =0;
		HashMap<String, Double> ans;
		try{
			File file = new File(fileName);
			ArrayList<String> data = new ArrayList<>();
			Scanner reader = new Scanner(file);
			reader.nextLine();
			while(reader.hasNextLine()){
				data.add(reader.nextLine());
			}
			ArrayList<String> categories = new ArrayList<String>();
			ArrayList<Double> amount = new ArrayList<Double>();
			for(int i=0; i<data.size(); i++){
				String[] line = data.get(i).split(",");
				int place = categories.indexOf(line[2]);//contains the category
				double replace = Double.parseDouble(line[1]);
				if(place == -1){
					categories.add(line[2]);
					amount.add(replace);
				}
				else{
					double old = amount.get(place);
					amount.add(place, old+replace);
				}

			}
			ans = new HashMap<String, Double>();
			for(int j=0; j<categories.size(); j++){
				ans.put(categories.get(j), amount.get(j));
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
			return null;
		}
		return ans;
	}
	
	public static double loadSavingsGoal(String fileName){
		double goal =0;
		try{
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			reader.nextLine();//get rid of header
			while(reader.hasNext()){
				goal = reader.nextDouble();
				reader.nextLine();
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			return -1;
		}
		catch(InputMismatchException e){
			return 0;
		}
		return goal;
	}

    
}
