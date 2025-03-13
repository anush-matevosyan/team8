import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVReader{
    public static void main(String[] args){
        String fileName = "hannahChase.csv";
        File file = new File(fileName);
        List<List<String>> chart = new ArrayList<>();
        Scanner scanner;
           
        try{
            scanner = new Scanner(file);
            scanner.next();
            while(scanner.hasNext()){
                String row = scanner.next();
                String[] value = row.split(",|\n");
                chart.add(Arrays.asList(value));
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        try{
            FileWriter writer = new FileWriter("ExpenseReport.txt");
            writer.write("Expense Report\n");
            writer.write("\nDate\tAmount\tCategory\tNotes\n");
        
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
}