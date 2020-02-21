package app;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    public double calculateMonthlyInterest(){
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance = savingsBalance + monthlyInterest;
        return monthlyInterest;
    }

    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }
    // Need to use this for the formatted table
    public double getSavingsBalance(){
        return savingsBalance;
    }
}