package app;

import java.util.TreeMap;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Formatter;
import java.io.FileNotFoundException;

public class DuplicateCounter {
    private TreeMap<String, Integer> wordCounter = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void count(String dataFile){
        try (Scanner input = new Scanner(Path.of(dataFile))){
            int count;
            while (input.hasNext()){
                String fileWord = input.next();

                if (wordCounter.containsKey(fileWord)){
                    count = wordCounter.get(fileWord);
                    wordCounter.put(fileWord, count + 1);
                }
                else {
                    wordCounter.put(fileWord, 1);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could Not Open File. File Name May Not Exist.");
            System.exit(-1);
        }
    }
    
    public void write(String outputFile){
        try (Formatter output = new Formatter(outputFile)){
            for (String i: wordCounter.keySet()){
                output.format("%s: %dx%n", i, wordCounter.get(i));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found.");
            System.exit(-2);
        }
        catch (SecurityException e){
            System.out.println("You do not have permission to write to this file.");
            System.exit(0);
        }
    }
}