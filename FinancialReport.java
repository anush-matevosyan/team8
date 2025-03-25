import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.stage.Modality; 

import javafx.stage.Stage; 

import java.io.IOException; 

import java.nio.file.Files; 

import java.nio.file.Paths; 

import java.util.List; 

import javafx.scene.chart.PieChart;

import java.util.Map;

import javafx.scene.text.Text;

  

public class FinancialReport { 

    public FinancialReport(Stage parentStage) { 

        Stage financialStage = new Stage(); 

        financialStage.initModality(Modality.APPLICATION_MODAL); 

        financialStage.setTitle("Financial Report"); 
	Writing write = new Writing("savingsGoal.txt");
	double sum = CSVReader.summary("spendings.csv");
	double goal = write.loadSavingsGoal();
	Text txtSum = new Text();
	
	Text txtGoal = new Text();
		
	txtSum.setText(String.valueOf(sum));
		
	txtGoal.setText(String.valueOf(goal));
	Label save = new Label("Your Savings Goal: ");
		
	Label spend = new Label("The Amount you Spend: ");
	

	Label saved = new Label("Money saved: ");
	
	Text left = new Text();
		

	PieChart pieChart = new PieChart();
        Map<String, Double> expenses = CSVReader.getCategoryExpenses("spendings.csv");
		

        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            pieChart.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
	
	left.setText(String.valueOf(goal-sum));
        VBox layout = new VBox(pieChart, save, txtGoal, spend, txtSum, saved, left); 

        layout.setAlignment(Pos.CENTER); 

        Scene scene = new Scene(layout, 700, 600); 

        financialStage.setScene(scene); 

        financialStage.showAndWait(); 
    } 

}
