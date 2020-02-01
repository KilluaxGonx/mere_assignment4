package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] cypherArray;
        int i;

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("\nEnter a four digit integer: ");
            String userString = input.nextLine();

            Encrypter cypherText = new Encrypter();
            cypherArray = cypherText.encrypt(userString);

            if (cypherArray[0] < 0){
                System.out.println("Invalid input.");
            }
            else {
                for (i = 0; i < 4; i++){
                    System.out.print(cypherArray[i]);
                }
            }
        }
    }
}