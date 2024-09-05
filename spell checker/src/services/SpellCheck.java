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

    public List<String> findMisspelledWords(File dictionaryFile, File fileToCheck) {
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
                    boolean isCapitalized = false;

                    //Remove "." and ","
                    if (wordToCheck.indexOf('.') >= 0 || wordToCheck.indexOf(',')  >= 0 || wordToCheck.indexOf('?') >= 0) {
                        wordToCheck = wordToCheck.substring(0, wordToCheck.length() - 1);
                    }

                    // Is the word a, A or I?
                    if (wordToCheck.equals("a") || wordToCheck.equals("A") || wordToCheck.equals("I")) {
                        continue;
                    }

                    //Check dictionary for lowercase word
                    String lowerCase = wordToCheck.toLowerCase();
                    if (!wordToCheck.equals(lowerCase)) {
                        isCapitalized = true;
                    }

                    Scanner dictionary = new Scanner(dictionaryFile);

                    while (dictionary.hasNext()) {
                        String wordInDictionary = dictionary.next();
                        if (lowerCase.equals(wordInDictionary)) {
                            break;
                        }

                        if (!dictionary.hasNext()) {
                            // if lowercase is not in dictionary, I'm assuming it's a proper noun
                            if (!isCapitalized) {
                                misspelledWords.add(lowerCase);
                            }
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
