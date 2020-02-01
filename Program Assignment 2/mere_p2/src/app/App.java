package app;

public class App {
    public static void main(String[] args) {
        BMICalculator app = new BMICalculator();
        app.readUserData();
        app.calculateBmi();
        app.displayBmi();
    }
}