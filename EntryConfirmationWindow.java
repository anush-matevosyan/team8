package pROJ1;

import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.stage.Modality; 

import javafx.stage.Stage; 

import javafx.scene.paint.Color; 

import javafx.scene.text.Text; 

  

public class EntryConfirmationWindow { 

    public EntryConfirmationWindow(String date, String category, String amount, String note, Stage addEntryStage) { 

        Stage confirmationStage = new Stage(); 

        confirmationStage.initModality(Modality.APPLICATION_MODAL); 

        confirmationStage.setTitle("Confirmation"); 

         

        Label dateLabel = new Label("Date: " + date); 

        Label categoryLabel = new Label("Category: " + category); 

        Label amountLabel = new Label("Amount: " + amount); 

        Label noteLabel = new Label("Note: " + note); 

         

        // Amount display customization 

        Text amountText = new Text("Amount: " + amount); 

        try { 

            double amountValue = Double.parseDouble(amount); 

            if ("Income".equalsIgnoreCase(category)) { 

                amountText.setFill(Color.GREEN); 

                amountText.setText("Amount: +$" + amount); 

            } else { 

                amountText.setFill(Color.RED); 

                amountText.setText("Amount: -$" + amount); 

            } 

        } catch (NumberFormatException e) { 

            amountText.setFill(Color.RED); 

            amountText.setText("Invalid amount entered"); 

        } 

         

        Button confirmButton = new Button("Confirm and Return"); 

        confirmButton.setOnAction(e -> {
        	confirmationStage.close();
        	addEntryStage.close();
        }); 

         

        Button editButton = new Button("Edit Further"); 

        editButton.setOnAction(e -> { 

            confirmationStage.close(); 

            addEntryStage.show(); 

        }); 

         

        VBox layout = new VBox(10, dateLabel, categoryLabel, amountText, noteLabel, confirmButton, editButton); 

        layout.setAlignment(Pos.CENTER); 

         

        Scene scene = new Scene(layout, 300, 250); 

        confirmationStage.setScene(scene); 

        confirmationStage.showAndWait(); 

    } 

} 
