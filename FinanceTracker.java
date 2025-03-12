import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.*;

public class FinanceTracker extends Application {
    private BorderPane rootLayout;
    
    // Dummy Data for Expenses and Income
    private final List<Expense> expenses = Arrays.asList(
            new Expense("Food", 200, "2025-01-10"),
            new Expense("Transport", 150, "2025-01-12"),
            new Expense("Entertainment", 100, "2025-01-15"),
            new Expense("Food", 250, "2025-02-05"),
            new Expense("Transport", 180, "2025-02-10")
    );

    private final List<Income> incomes = Arrays.asList(
            new Income(1000, "2025-01-01"),
            new Income(1200, "2025-02-01"),
            new Income(1100, "2025-03-01")
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        rootLayout = new BorderPane();
        Scene scene = new Scene(rootLayout, 800, 600);
        primaryStage.setTitle("Income vs Expenses Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();

        showCharts();
    }

    private void showCharts() {
        // Pie Chart for Expenses by Category
        PieChart pieChart = new PieChart();
        Map<String, Double> categoryExpenses = calculateMonthlyExpensesByCategory();
        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
            pieChart.getData().add(slice);
        }
        pieChart.setTitle("Category-wise Expenses");

        // Bar Chart for Income vs. Expenses
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Income vs Expenses Comparison");
        xAxis.setLabel("Month");
        yAxis.setLabel("Amount");

        XYChart.Series<String, Number> incomeSeries = new XYChart.Series<>();
        incomeSeries.setName("Income");
        Map<String, Double> monthlyIncome = calculateMonthlyIncome();
        for (Map.Entry<String, Double> entry : monthlyIncome.entrySet()) {
            incomeSeries.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        XYChart.Series<String, Number> expensesSeries = new XYChart.Series<>();
        expensesSeries.setName("Expenses");
        Map<String, Double> monthlyExpenses = calculateTotalMonthlyExpenses();
        for (Map.Entry<String, Double> entry : monthlyExpenses.entrySet()) {
            expensesSeries.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        barChart.getData().addAll(incomeSeries, expensesSeries);

        VBox vbox = new VBox(new Label("Financial Overview"), pieChart, barChart);
        rootLayout.setCenter(vbox);
    }

    public Map<String, Double> calculateMonthlyExpensesByCategory() {
        Map<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : expenses) {
            categoryTotals.merge(expense.getCategory(), expense.getAmount(), Double::sum);
        }
        return categoryTotals;
    }

    public Map<String, Double> calculateMonthlyIncome() {
        Map<String, Double> monthlyIncome = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        for (Income income : incomes) {
            String month = formatter.format(income.getDate());
            monthlyIncome.merge(month, income.getAmount(), Double::sum);
        }
        return monthlyIncome;
    }

    public Map<String, Double> calculateTotalMonthlyExpenses() {
        Map<String, Double> monthlyExpenses = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        for (Expense expense : expenses) {
            String month = formatter.format(expense.getDate());
            monthlyExpenses.merge(month, expense.getAmount(), Double::sum);
        }
        return monthlyExpenses;
    }

    // Expense Class
    static class Expense {
        private final String category;
        private final double amount;
        private final Date date;

        public Expense(String category, double amount, String dateString) {
            this.category = category;
            this.amount = amount;
            this.date = parseDate(dateString);
        }

        public String getCategory() {
            return category;
        }

        public double getAmount() {
            return amount;
        }

        public Date getDate() {
            return date;
        }

        private Date parseDate(String dateString) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (Exception e) {
                return new Date();
            }
        }
    }

    // Income Class
    static class Income {
        private final double amount;
        private final Date date;

        public Income(double amount, String dateString) {
            this.amount = amount;
            this.date = parseDate(dateString);
        }

        public double getAmount() {
            return amount;
        }

        public Date getDate() {
            return date;
        }

        private Date parseDate(String dateString) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (Exception e) {
                return new Date();
            }
        }
    }
}
