package app;

public class App {
    public static void main(String[] args) throws Exception {
        DuplicateRemover test = new DuplicateRemover();
        test.remove("problem1.txt");
        test.write("unique_words.txt");
    }
}