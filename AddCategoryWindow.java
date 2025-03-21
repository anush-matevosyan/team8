package pROJ1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddCategoryWindow {
    public static void open(TextArea categoryTextArea) {
        Stage addStage = new Stage();
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.setTitle("Add New Category");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter new category");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String newCategory = inputField.getText().trim();
            if (!newCategory.isEmpty()) {
                try {
                    //under construction
                }
            }
        }); 

        VBox layout = new VBox(10, new Label("New Category:"), inputField, saveButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 250, 150);
        addStage.setScene(scene);
        addStage.showAndWait();
    }
}