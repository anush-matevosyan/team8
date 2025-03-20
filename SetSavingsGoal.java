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

import javafx.scene.layout.*;

import javafx.geometry.Insets;

public class SetSavingsGoal {

    public SetSavingsGoal(Stage parentStage) {
        
		Stage savingsStage = new Stage();
		
		savingsStage.initModality(Modality.APPLICATION_MODAL); 

        savingsStage.setTitle("Set Savings Goal");

        Label lblGoal = new Label("Enter your monthly savings goal:");
        TextField txtGoal = new TextField();
		Writing write = new Writing("savingsGoal.txt");
        double existingGoal = write.loadSavingsGoal();
        if (existingGoal != -1) {
            txtGoal.setText(String.valueOf(existingGoal));
        }

        Button btnSave = new Button("Save Goal");
        btnSave.setOnAction(e -> {
            try {
                double goal = Double.parseDouble(txtGoal.getText());
                write.saveSavingsGoal(goal);
				double spend = CSVReader.summary("spendings.csv");
				if(spend > goal){
					AlertError error = new AlertError();
				}
                savingsStage.close();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid goal amount!");
                alert.showAndWait();
            }
        });

        VBox layout = new VBox(10, lblGoal, txtGoal, btnSave);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 150);
        savingsStage.setScene(scene);
        savingsStage.showAndWait();
    }
}
