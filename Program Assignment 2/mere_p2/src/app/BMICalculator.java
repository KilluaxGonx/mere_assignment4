package app;
import java.util.Scanner;
public class BMICalculator {
    Scanner input = new Scanner(System.in);
    private String choice;
    private double height;
    private double weight;
    private double BMI;
    private String BMICategory;
    
    public BMICalculator(){
        this.choice = "0";
        this.height = 0.0;
        this.weight = 0.0;
        this.BMI = 0.0;
        this.BMICategory = "Underweight (< 18.5)";
    }
    private void readUnitType(){
        System.out.println("1. Calculate BMI (Kilogram/Meters)");
        System.out.println("2. Calculate BMI (Pounds/Inchces)");

        System.out.printf("%nEnter 1 or 2 for unit type: ");
        this.choice = input.nextLine();
        while (this.choice.equals("1") != true && this.choice.equals("2") != true){ // Takes only 1 or 2 as real values
            System.out.printf("%nInvalid Input. Enter 1 (metric) or 2 (imperial) for unit type: ");
            this.choice = input.nextLine();
        }
    }

    private void readMeasurementData(){
        if (this.choice.equals("1")){
            readMetricData();
        }
        else if (this.choice.equals("2")) {
            readImperialData();
        }
    }
    private void readMetricData(){
        System.out.println("Enter your weight (kilograms): ");
        setWeight();
        System.out.println("Enter your height (meters): ");
        setHeight();
    }
    private void readImperialData(){
        System.out.println("Enter your weight (pounds): ");
        setWeight();
        System.out.println("Enter your height (inches): ");
        setHeight();
    }

    public void readUserData(){
        readUnitType();
        readMeasurementData();
    }
    public void calculateBmi(){
        if (this.choice.equals("1")){
            this.BMI = (this.weight) / ((this.height) * (this.height));
            calculateBmiCategory();
        }
        else {
             this.BMI = (703 * this.weight) / ((this.height) * (this.height));
             calculateBmiCategory();
        }
    }
    private void calculateBmiCategory(){
        if (this.BMI < 18.5){
            this.BMICategory = "Underweight (< 18.5)";
        }
        else if (this.BMI >= 18.5 && this.BMI <= 24.9){
            this.BMICategory = "Normal Weight (18.5 - 24.9)";
        }
        else if (this.BMI > 24.9 && this.BMI < 29.9){
            this.BMICategory = "Overweight (24.9 - 29.9)";
        }
        else {
            this.BMICategory = "Obese (> 29.9)";
        }
    }
    public void displayBmi(){
        System.out.printf("%n--------BMI Report---------%n");
        System.out.printf("BMI: %14.2f%n", this.BMI);
        System.out.printf("BMI Category: %s%n", this.BMICategory);
        System.out.println("---------------------------");
    }
    public double getWeight(){
        return weight;
    }
    public double getHeight(){
        return height;
    }
    public double getBmi(){
        return BMI;
    }
    public String getBmiCategory(){
        return BMICategory;
    }
    private void setWeight(){
        this.weight = input.nextDouble();
        if (this.weight < 0){
            System.exit(-1);
        }
    }
    private void setHeight(){
        this.height = input.nextDouble();
        if (this.height < 0){
            System.exit(-1);
        }
    }
}