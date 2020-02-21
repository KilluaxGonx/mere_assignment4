package app;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI1 {
    SecureRandom digits = new SecureRandom();
    Scanner input = new Scanner(System.in);
    int response;
    int num1;
    int num2;

    public static void main(String[] args) {
        CAI1 q = new CAI1();
        q.quiz();
    }
    private void quiz(){
        generateNumbers();
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
        System.out.println("Very Good!");
    }
    private void displayIncorrectResponse(){
        System.out.println("No. Please Try Again.");
    }
    private void generateNumbers(){
        num1 = digits.nextInt(10);
        num2 = digits.nextInt(10);
    }
}