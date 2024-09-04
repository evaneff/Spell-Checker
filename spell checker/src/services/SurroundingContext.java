package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SurroundingContext {

    public SurroundingContext(){
    }

    public String findContext(File file, String word) {


        String result = "";
        String regex = "(?:\\S+\\s+){0,3}" + word + "\\S*\\s*(?:\\S+\\s*){0,3}";

        Pattern pattern = Pattern.compile(regex);

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String next = sc.nextLine();

                Matcher match = pattern.matcher(next);

                if (match.find()) {
                    result = match.group();
                }

            }

            //works just fine on regex101.com

            // line terminators definitely the problem

            //result = sc.findInLine(pattern);


        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return result;
    }
}
