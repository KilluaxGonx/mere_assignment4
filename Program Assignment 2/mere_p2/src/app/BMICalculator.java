package app;
import java.util.Scanner;
public class BMICalculator {
    private int choice;
    private double height;
    private double weight;
    private double BMI;
    private String BMICategory;
    
    public BMICalculator(){
        this.choice = 0;
        this.height = 0.0;
        this.weight = 0.0;
        this.BMI = 0.0;
        this.BMICategory = "Underweight";
    }

    public void readUserData(){
        System.out.println("1. Calculate BMI (Kilogram/Meters)");
        System.out.println("2. Calculate BMI (Pounds/Inchces)");
        Scanner input = new Scanner(System.in);
        
        while (this.choice != 1 && this.choice != 2){
            System.out.printf("%nEnter a number: ");
            this.choice = Integer.parseInt(input.next());

            if (this.choice == 1){
                System.out.println("Enter your weight (kilograms): ");
                this.weight = input.nextDouble();
                if (this.weight < 0){
                    System.exit(-1);
                }
                System.out.println("Enter your height (meters): ");
                this.height = input.nextDouble();
                if (this.height < 0){
                    System.exit(-1);
                }
            }
            else if (this.choice == 2) {
                System.out.println("Enter your weight (pounds): ");
                this.weight = input.nextDouble();
                if (this.weight < 0){
                    System.exit(-1);
                }
                System.out.println("Enter your height (inches): ");
                this.height = input.nextDouble();
                if (this.height < 0){
                    System.exit(-1);
                }
            }
            else {
                System.out.println("Invalid Input.");
            }
        }
        input.close();
    }
    public void calculateBmi(){
        if (this.choice == 1){
            this.BMI = (this.weight) / ((this.height) * (this.height));
            if (this.BMI < 18.5){
                this.BMICategory = "Underweight";
            }
            else if (this.BMI >= 18.5 && this.BMI <= 24.9){
                this.BMICategory = "Normal Weight";
            }
            else if (this.BMI > 24.9 && this.BMI < 29.9){
                this.BMICategory = "Overweight";
            }
            else {
                this.BMICategory = "Obese";
            }
        }
        else {
             this.BMI = (703 * this.weight) / ((this.height) * (this.height));
            if (this.BMI < 18.5){
                this.BMICategory = "Underweight";
            }
            else if (this.BMI >= 18.5 && this.BMI <= 24.9){
                this.BMICategory = "Normal Weight";
            }
            else if (this.BMI > 24.9 && this.BMI < 29.9){
                this.BMICategory = "Overweight";
            }
            else {
                this.BMICategory = "Obese";
            }
        }
    }
    public void displayBmi(){
        System.out.printf("%n--------BMI Report---------%n");
        System.out.printf("Height: %11.2f%n", this.height);
        System.out.printf("Weight: %11.2f%n", this.weight);
        System.out.printf("BMI: %14.2f%n", this.BMI);
        System.out.printf("BMI Category: %s%n", this.BMICategory);
        System.out.println("---------------------------");
    }
}