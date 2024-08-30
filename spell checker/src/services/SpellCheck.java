package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class SpellCheck {

    public SpellCheck() {
    }

    public void findMisspelledWords(File dictionary, File fileToCheck) {
        //find each word from fileToCheck in dictionary?!?!
       // Scanner dict = null;
        Scanner file = null;
        try {
        //dict = new Scanner(dictionary);
        file = new Scanner(fileToCheck);
        } catch (FileNotFoundException e) {
        System.out.println("file not found");
        }

        if (file != null) {
            while (file.hasNext()) {
                try {
                    Scanner dict = new Scanner(dictionary);
                    String wordToCheck = file.next().toLowerCase();

                    if (wordToCheck.indexOf('.') >= 0 || wordToCheck.indexOf(',') >= 0) {
                        wordToCheck = wordToCheck.substring(0, wordToCheck.length() -1);
                    }
                    while (dict.hasNext()) {
                        String check = dict.next();
                        if (wordToCheck.equals(check)) {
                            break;
                        }
                        if (!dict.hasNext()) {
                            System.out.println("misspelled word: " + wordToCheck);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("dictionary not found");
                }



            }
        }
    }
}
