//package pROJ1;
package team8;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyCategoriesWindow 
{
    public MyCategoriesWindow(Stage parentStage) {
        Stage categoryStage = new Stage();
        categoryStage.initModality(Modality.APPLICATION_MODAL);
        categoryStage.setTitle("My Categories");
        
        TextArea categoryTextArea = new TextArea();
        categoryTextArea.setEditable(false);
        loadCategories(categoryTextArea);
        
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");
        
        VBox layout = new VBox(10, categoryTextArea, addButton, removeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout, 300, 400);
        categoryStage.setScene(scene);
        categoryStage.showAndWait();
    }

    private void loadCategories(TextArea textArea) {
        try {
            String categories = new String(Files.readAllBytes(Paths.get("categories.txt")));
            textArea.setText(categories);
        } catch (IOException e) {
            textArea.setText("Error loading categories");
        }
    }
}
