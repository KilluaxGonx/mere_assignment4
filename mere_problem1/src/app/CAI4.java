package app;
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI4 {
    SecureRandom digits = new SecureRandom();
    Scanner input = new Scanner(System.in);
    int response, num1, num2, correct, incorrect, count, difficulty; // easy class variables for simplicity
 
    public static void main(String[] args) {
        CAI4 q = new CAI4();
        q.quiz(); // Did this to call the non-static methods
    }
    private void quiz(){
        incorrect = 0; correct = 0; count = 0;
        readDifficulty();
        while (true){
            generateQuestionArgument(); // Moved into while loop for one chance per question
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
        System.out.printf("%d) How much is %d times %d? ", count+1, num1, num2);
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
    private void generateQuestionArgument(){
        switch (difficulty){
            case 1:
            num1 = digits.nextInt(10); num2 = digits.nextInt(10);
            break;

            case 2:
            num1 = digits.nextInt(100);
            num2 = digits.nextInt(100);
            break;

            case 3:
            num1 = digits.nextInt(1000);
            num2 = digits.nextInt(1000);
            break;

            case 4:
            num1 = digits.nextInt(10000);
            num2 = digits.nextInt(10000);
            break;
        }
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

    private void readDifficulty(){
        System.out.println("1) Newbie   - Use only single digit numbers.");
        System.out.println("2) Casual   - Include double digit numbers.");
        System.out.println("3) Veteran  - Include triple digit numbers.");
        System.out.println("4) Hardcore - Include quadruple digit numbers.");
        System.out.println();

        System.out.print("Enter your difficulty level (1-4): ");
        difficulty = input.nextInt();
        System.out.println();
    }

}