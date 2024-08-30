package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SurroundingContext {

    public SurroundingContext(){
    }

    public String findContext(File file, String word) {


        String result = "";

        try {
            Scanner sc = new Scanner(file);

            // 3 words before and after word
            String regex = "((?:\\S+\\s+){0,3}\\b" + word + "\\b\\s*(?:\\S+\\b\\s*){0,3})";

            Pattern pattern = Pattern.compile(regex);
            
            result += sc.findInLine(pattern);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return result;
    }
}
