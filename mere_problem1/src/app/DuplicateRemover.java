package app;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;
import java.util.Formatter;

public class DuplicateRemover {
    private Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    public void remove(String dataFile){
        try (Scanner input = new Scanner(Path.of(dataFile))){
            while (input.hasNext()){
                uniqueWords.add(input.next());
            }
        }
        catch (IOException e) {
            System.out.println("Could not open file.");
        }
    }
    public void write(String outputFile){
        try (Formatter output = new Formatter(outputFile)){
            for (String i: uniqueWords){
                output.format("%s%n", i);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found.");
        }
        catch (SecurityException e){
            System.out.println("You do not have permission to write to this file.");
        }
    }
}