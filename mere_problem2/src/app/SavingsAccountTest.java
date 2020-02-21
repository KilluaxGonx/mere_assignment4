package app;

import java.text.NumberFormat;

public class SavingsAccountTest {
    public static void main(String arg[]){
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        SavingsAccount.modifyInterestRate(0.04);
        displayTable(saver1, saver2, 4);
        SavingsAccount.modifyInterestRate(0.05);
        displayTable(saver1, saver2, 5);
    }
    // Creates a formatted table that displays 12 months of compounding interest in user's savings account
    public static void displayTable(SavingsAccount saver1, SavingsAccount saver2, int rate){
        System.out.println("Effective Savings Annual Report");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("SAVER 1                                  |             SAVER 2");
        System.out.println("-----------------------------------------|--------------------------------------");
        System.out.printf("Deposit: $%.2f                        |             ", saver1.getSavingsBalance());
        System.out.printf("Deposit: $%.2f%n", saver2.getSavingsBalance());
        System.out.printf("Annual Interest Rate: %d%%                 |             Annual Interest Rate: %d%%%n", rate,rate);
        System.out.println("-----------------------------------------|---------------------------------------");
        System.out.println("Mon | S.Balance | Int.Earned | E.Balance | S.Balance | Int.Earned | E.Balance |");
        System.out.println("-----------------------------------------|---------------------------------------");
        for (int i = 0; i < 12; i++){
            System.out.printf("%2d", i+1);
            NumberFormat nf = NumberFormat.getCurrencyInstance(); // Formats data to currency for clearer printing
            System.out.printf("%13s", nf.format(saver1.getSavingsBalance()));
            System.out.printf("%10s", nf.format(saver1.calculateMonthlyInterest()));
            System.out.printf("%15s |", nf.format(saver1.getSavingsBalance()));

            System.out.printf("%11s", nf.format(saver2.getSavingsBalance()));
            System.out.printf("%10s", nf.format(saver2.calculateMonthlyInterest()));
            System.out.printf("%15s", nf.format(saver2.getSavingsBalance()));
            System.out.println();
        }
        System.out.println();
    }
}   

