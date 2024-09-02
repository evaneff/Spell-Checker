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

            //works just fine on regex101.com

            // line terminators definitely the problem

            String regex = "(?:\\S+\\s+){0,3}" + word + "\\S*\\s*(?:\\S+\\s*){0,3}";


            Pattern pattern = Pattern.compile(regex);

            result = sc.findInLine(pattern);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return result;
    }
}
