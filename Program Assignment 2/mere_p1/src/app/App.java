package app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[] cypherArray, messageArray;
        int i, choice = 0;
        Scanner input = new Scanner(System.in);

        while (choice != 3){
            System.out.printf("%n%n1. Encrypt data%n2. Decrypt data%n3. Quit%n");
            System.out.printf("%nSelect an option (Enter number): ");
            choice = Integer.parseInt(input.nextLine());
            if (choice == 1){
//Encrypting
                System.out.print("\nEnter a four digit integer: ");
                String userString = input.nextLine();
                Encrypter cypherText = new Encrypter();
                cypherArray = cypherText.encrypt(userString);

                if (cypherArray[0] < 0){
                    System.out.println("Invalid input.");
                }
                else {
                    System.out.print("Cypher Text: ");
                    for (i = 0; i < 4; i++){
                        System.out.print(cypherArray[i]);
                    }
                }
            }
            else if (choice == 2){
//Decrypting
                System.out.print("\nEnter a four digit integer: ");
                String userString = input.nextLine();
                Decrypter userMessage = new Decrypter();
                messageArray = userMessage.decrypt(userString);

                if (messageArray[0] < 0){
                    System.out.println("Invalid input.");
                }
                else {
                    System.out.print("Data Message: ");
                    for (i = 0; i < 4; i++){
                        System.out.print(messageArray[i]);
                    }
                }
            }
            else {
                break;
            }
        }
        System.out.println("Goodbye!");
        input.close();
    }
}