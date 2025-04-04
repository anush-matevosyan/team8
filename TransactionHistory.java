package team8;
import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.stage.Modality; 

import javafx.stage.Stage; 

public class TransactionHistory { 

    public TransactionHistory(Stage parentStage) { 

        Stage transactionStage = new Stage(); 

        transactionStage.initModality(Modality.APPLICATION_MODAL); 

        transactionStage.setTitle("Transaction History"); 

		String fileName = "spendings.csv";
		CSVReader.read(fileName);
	
		Label history = new Label("Your text file with the transaction history \nhas been created!");
		
        VBox layout = new VBox(10, history); 

        layout.setAlignment(Pos.CENTER); 

        Scene scene = new Scene(layout, 300, 100); 

        transactionStage.setScene(scene); 

        transactionStage.showAndWait(); 
    } 

}
