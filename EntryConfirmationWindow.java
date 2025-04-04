//package pROJ1;
package team8;

import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.stage.Modality; 

import javafx.stage.Stage; 

import javafx.scene.paint.Color; 

import javafx.scene.text.Text; 

  

public class EntryConfirmationWindow { 

    public EntryConfirmationWindow(String[] data, Stage addEntryStage) { 

        Stage confirmationStage = new Stage(); 

        confirmationStage.initModality(Modality.APPLICATION_MODAL); 

        confirmationStage.setTitle("Confirmation"); 

         

        Label dateLabel = new Label("Date: " + data[0]); 

        Label categoryLabel = new Label("Category: " + data[2]); 

        //Label amountLabel = new Label("Amount: " + data[1]); 

        Label noteLabel = new Label("Note: " + data[3]); 

         

        // Amount display customization 

        Text amountText = new Text("Amount: " + data[1]); 

        try { 

            double amountValue = Double.parseDouble(data[1]); 

            if ("Income".equalsIgnoreCase(data[2])) { 

                amountText.setFill(Color.GREEN); 

                amountText.setText("Amount: +$" + amountValue); 

            } else { 

                amountText.setFill(Color.RED); 

                amountText.setText("Amount: -$" + amountValue); 

            } 

        } catch (NumberFormatException e) { 

            amountText.setFill(Color.RED); 

            amountText.setText("Invalid amount entered"); 

        } 

         

        Button confirmButton = new Button("Confirm and Return"); 

        confirmButton.setOnAction(e -> {
        	CSVWriting write = new CSVWriting("spendings.csv");
            write.writingData(data);
		    double spend = CSVReader.summary("spendings.csv");
		    double goal = CSVReader.loadSavingsGoal("savingsGoal.txt");
            if(spend > goal){
            	AlertError error = new AlertError();
            }
        	confirmationStage.close();
        	addEntryStage.close();
        }); 

        //amountText, 

        Button editButton = new Button("Edit Further"); 

        editButton.setOnAction(e -> { 

            confirmationStage.close(); 

            //addEntryStage.show(); 

        }); 

         

        VBox layout = new VBox(10, dateLabel, categoryLabel, amountText, noteLabel, confirmButton, editButton); 

        layout.setAlignment(Pos.CENTER); 

         

        Scene scene = new Scene(layout, 300, 250); 

        confirmationStage.setScene(scene); 

        confirmationStage.showAndWait(); 

    } 

} 
