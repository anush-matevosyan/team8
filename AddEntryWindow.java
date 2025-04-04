package team8;

import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.stage.Modality; 

import javafx.stage.Stage;

//import test.AlertError;

import java.io.IOException; 

import java.nio.file.Files; 

import java.nio.file.Paths; 

import java.util.List; 

  

public class AddEntryWindow { 

    public AddEntryWindow(Stage parentStage) { 

        Stage addEntryStage = new Stage(); 

        addEntryStage.initModality(Modality.APPLICATION_MODAL); 

        addEntryStage.setTitle("Add Entry"); 

  

        // Date Input 

        DatePicker datePicker = new DatePicker(); 

  

        // Category Selection 

        ComboBox<String> categoryComboBox = new ComboBox<>(); 

        try { 

            List<String> categories = Files.readAllLines(Paths.get("/home1/ugrads/j8d4n/eclipse-workspace/FinanceManager/qwerty/categories.txt")); 

            categoryComboBox.getItems().addAll(categories); 

        } catch (IOException e) { 

            categoryComboBox.getItems().add("Error loading categories"); 

        } 

         

        // Amount Input 

        TextField amountField = new TextField(); 

        amountField.setPromptText("Enter amount"); 

  

        // Additional Note 

        TextArea noteTextArea = new TextArea(); 

        noteTextArea.setPromptText("Enter additional notes..."); 

        noteTextArea.setPrefRowCount(3); 

  

        // Add Button 

        Button addButton = new Button("Add"); 
        
        addButton.setOnAction(e -> { 
        	String[] data = new String[4];
            
            data[0] = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "No Date Selected"; 

            data[2] = (categoryComboBox.getValue() != null) ? categoryComboBox.getValue() : "No Category Selected"; 

            data[1] = amountField.getText().isEmpty() ? "0" : amountField.getText(); 

            data[3] = noteTextArea.getText().isEmpty() ? "No Notes" : noteTextArea.getText(); 
            
            new EntryConfirmationWindow(data, parentStage);
            
        }); 

  

        VBox layout = new VBox(10, new Label("Select Date:"), datePicker, new Label("Select Category:"), categoryComboBox,  

                new Label("Enter Amount:"), amountField, new Label("Additional Notes:"), noteTextArea, addButton); 

        layout.setAlignment(Pos.CENTER); 

         

        Scene scene = new Scene(layout, 300, 350); 

        addEntryStage.setScene(scene); 

        addEntryStage.showAndWait(); 

    } 

}
