import javafx.application.Application; 

import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.scene.layout.Region; 

import javafx.stage.Stage; 

  

public class MainMenuWindow extends Application { 

    @Override 

    public void start(Stage primaryStage) { 

        primaryStage.setTitle("Personal Financial Manager"); 

  

        // Welcome message 

        Label welcomeLabel = new Label("Welcome to Your Personal Finance Manager!"); 

         

        // Empty space blocks 

        Region spacer1 = new Region(); 

        spacer1.setMinHeight(20); 

        Region spacer2 = new Region(); 

        spacer2.setMinHeight(20); 

  

        // Buttons for different actions with uniform width 

        Button addEntryButton = new Button("Add Entry"); 

        Button setGoalButton = new Button("Set Savings Goal"); 

        Button transactionHistoryButton = new Button("Transaction History"); 

        Button financialReportButton = new Button("Financial Report"); 

        Button myAlertsButton = new Button("My Alerts"); 

        Button myCategoriesButton = new Button("My Categories"); 

  

        // Set uniform width for buttons 

        double buttonWidth = 200; 

        addEntryButton.setMinWidth(buttonWidth); 

        setGoalButton.setMinWidth(buttonWidth); 

        transactionHistoryButton.setMinWidth(buttonWidth); 

        financialReportButton.setMinWidth(buttonWidth); 

        myAlertsButton.setMinWidth(buttonWidth); 

        myCategoriesButton.setMinWidth(buttonWidth); 

  

        // Add Entry Button Action 

        addEntryButton.setOnAction(e -> new AddEntryWindow(primaryStage)); 

  

        // Layout with center alignment 

        VBox layout = new VBox(10); 

        layout.setAlignment(Pos.CENTER); 

        layout.getChildren().addAll(welcomeLabel, spacer1, spacer2, addEntryButton, setGoalButton, transactionHistoryButton, 

                                    financialReportButton, myAlertsButton, myCategoriesButton); 

         

        // Scene setup 

        Scene scene = new Scene(layout, 300, 350); 

        primaryStage.setScene(scene); 

        primaryStage.show(); 

    } 

  

    public static void main(String[] args) { 

        launch(args); 

    } 

} 
