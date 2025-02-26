import javafx.application.Application; 

import javafx.geometry.Pos; 

import javafx.scene.Scene; 

import javafx.scene.control.*; 

import javafx.scene.layout.VBox; 

import javafx.scene.layout.Region; 

import javafx.stage.Stage; 

  

public class PersonalFinancialManager extends Application { 

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
  

        // Add Entry Button Action 

        addEntryButton.setOnAction(e -> new AddEntryWindow(primaryStage)); 
         

        // Scene setup 

        Scene scene = new Scene(layout, 300, 350); 

        primaryStage.setScene(scene); 

        primaryStage.show(); 

    } 

  

    public static void main(String[] args) { 

        launch(args); 

    } 

} 
