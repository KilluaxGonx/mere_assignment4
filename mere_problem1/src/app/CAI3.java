package app;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI3 {
    SecureRandom digits = new SecureRandom();
    Scanner input = new Scanner(System.in);
    int response, num1, num2, correct, incorrect, count; // easy class variables for simplicity
 
    public static void main(String[] args) {
        CAI3 q = new CAI3(); // Creates an instance of this class to call its non-static methods in main
        q.quiz(); 
    }
    private void quiz(){
        incorrect = 0; correct = 0; count = 0;
        while (true){
            generateNumbers(); // Moved into while loop for one chance per question
            askQuestion(num1, num2);
            readResponse();
            if (isAnswerCorrect(response)){
                displayCorrectResponse();
                correct++; count++;
            }
            else {
                displayIncorrectResponse();
                incorrect++; count++;
            }

            if (count == 10){
                break;
            }
        }
        displayCompletionMessage();
        if(newProblemSet()){
            quiz();
        }
        else {
            input.close();
            System.out.printf("Goodbye!");
            System.exit(0);
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
        System.out.println();
    }
    private void displayIncorrectResponse(){
        int choice = digits.nextInt(4) + 1;
        switch (choice){
            case 1:
            System.out.println("No. Please Try Again."); break;
            case 2:
            System.out.println("Wrong. Try once more."); break;
            case 3:
            System.out.println("Not Quite. Don't give up!"); break;
            case 4:
            System.out.println("No. Keep trying."); break;
        }
        System.out.println();
    }
    private void generateNumbers(){
        num1 = digits.nextInt(10);
        num2 = digits.nextInt(10);
    }
    private void displayCompletionMessage(){
        double score = (correct / 10.0) * 100;
        System.out.printf("Score: %.2f%% %n", score);
        System.out.printf("Correct: %d%n", correct);
        System.out.printf("Incorrect: %d%n", incorrect);
        if (score < 75){
            System.out.println("Please ask your teacher for exta help.");
        }
        else {
            System.out.println("Congratulations, you are ready for the next level!");
        }
        System.out.println();
    }
    private boolean newProblemSet(){
        System.out.println("Would you like a new set of problems?");
        System.out.print("Enter 1 to continue or 2 to quit: ");
        int choice = input.nextInt();
        System.out.println();

        if (choice == 1){
            return true;
        }
        return false;
    }

}