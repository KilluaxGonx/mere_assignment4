package app;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI2 {
    SecureRandom digits = new SecureRandom();
    Scanner input = new Scanner(System.in);
    int response;
    int num1 = digits.nextInt(10);
    int num2 = digits.nextInt(10);

    public static void main(String[] args) {
        CAI2 q = new CAI2();
        q.quiz(); // Did this to call the non-static metods
    }
    private void quiz(){

        while (true){
            askQuestion(num1, num2);
            readResponse();
            if (isAnswerCorrect(response)){
                displayCorrectResponse();
                input.close();
                System.exit(1);
            }
            displayIncorrectResponse();
        }

    }
    private void askQuestion(int num1, int num2){
        System.out.printf("How much is %d times %d? ", num1, num2);
    }
    private void readResponse(){
        response = input.nextInt();
    }
    private boolean isAnswerCorrect(int userAnswer){
        int answer = num1 * num2;
        if (userAnswer == answer){
            return true;
        }
        return false;
    }
    private void displayCorrectResponse(){
        int choice = digits.nextInt(4) + 1;
        switch (choice){
            case 1:
            System.out.println("Very Good!"); break;
            case 2:
            System.out.println("Excellent!"); break;
            case 3:
            System.out.println("Nice Work!"); break;
            case 4:
            System.out.println("Keep up the Good Work!"); break;
        }

    }
    private void displayIncorrectResponse(){
        int choice = digits.nextInt(4) + 1;
        switch (choice){
            case 1:
            System.out.println("No. Please Try Again."); break;
            case 2:
            System.out.println("Wrong. Try once more."); break;
            case 3:
            System.out.println("Don't give up!"); break;
            case 4:
            System.out.println("No. Keep trying."); break;
        }
    }
}