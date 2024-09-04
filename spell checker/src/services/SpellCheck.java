package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SpellCheck {

    public SpellCheck() {
    }

    public List<String> findMisspelledWords(File dictionary, File fileToCheck) {
        List<String> misspelledWords = new ArrayList<>();

        //find each word from fileToCheck in dictionary
        Scanner file = null;
        try {

            file = new Scanner(fileToCheck);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        if (file != null) {
            while (file.hasNext()) {
                try {
                    String wordToCheck = file.next();

                    //Remove "." and ","
                    if (wordToCheck.indexOf('.') >= 0 || wordToCheck.indexOf(',') >= 0) {
                        wordToCheck = wordToCheck.substring(0, wordToCheck.length() - 1);
                    }

                    // Is the word a, A or I?
                    if (wordToCheck.equals("a") || wordToCheck.equals("A") || wordToCheck.equals("I")) {
                        break;
                    }

                    //Check dictionary for lowercase word
                    wordToCheck = wordToCheck.toLowerCase();

                    Scanner dict = new Scanner(dictionary);

                    while (dict.hasNext()) {
                        String check = dict.next();
                        if (wordToCheck.equals(check)) {
                            break;
                        }

                        if (!dict.hasNext()) {

                            // is it a proper noun?? or just misspelled capitalized word?

                            //contractions??

                            misspelledWords.add(wordToCheck);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("dictionary not found");
                }
            }
        }
        return misspelledWords;
    }
}
