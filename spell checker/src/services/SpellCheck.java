package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SpellCheck {

    SurroundingContext context = new SurroundingContext();
    SuggestedWords suggestions = new SuggestedWords();

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

                    String wordToCheck = file.next();

                    //Remove "." and ","
                    if (wordToCheck.indexOf('.') >= 0 || wordToCheck.indexOf(',') >= 0) {
                        wordToCheck = wordToCheck.substring(0, wordToCheck.length() -1);
                    }

                    // Is the word a, A or I?
                    if (wordToCheck.equals("a") || wordToCheck.equals("A") || wordToCheck.equals("I")) {
                        break;
                    }

                    //Check dictionary for lowercase word
                    wordToCheck = wordToCheck.toLowerCase();

                    while (dict.hasNext()) {
                        String check = dict.next();
                        if (wordToCheck.equals(check)) {
                            break;
                        }


                        if (!dict.hasNext()) {

                            // is it a proper noun?? or just misspelled capitalized word?

                            //contractions??


                            //find surrounding context
                            String contextResult = context.findContext(fileToCheck, wordToCheck);

                            //find suggested words
                            List<String> suggestionsResult = suggestions.suggestWords(dictionary, wordToCheck);


                            System.out.println("\nmisspelled word: " + wordToCheck);
                            System.out.println("context: " + contextResult);
                            System.out.println("Suggested words:" );
                            for (String word: suggestionsResult) {
                                System.out.println(word);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("dictionary not found");
                }



            }
        }
    }
}
