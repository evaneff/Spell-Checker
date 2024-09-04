
import services.SpellCheck;
import services.SuggestedWords;
import services.SurroundingContext;

import java.io.File;
import java.util.List;


public class App {
    public static void main(String[] args) {

        SurroundingContext context = new SurroundingContext();
        SuggestedWords suggestions = new SuggestedWords();

//        File dictionary = new File(args[0]);
//        File fileToCheck = new File(args[1]);
        File dictionary = new File("src/dictionary.txt");
        File fileToCheck = new File("src/file-to-check.txt");

        SpellCheck checker = new SpellCheck();

        List<String> misspelledWords = checker.findMisspelledWords(dictionary, fileToCheck);

        // check for proper nouns somehow...

        for (String word: misspelledWords) {
            //still could be a misspelled capitalized word
            System.out.println("\nmisspelled word: " + word);

            String contextResult = context.findContext(fileToCheck, word);

            System.out.println("context: " + contextResult);

            List<String> suggestionsResult = suggestions.suggestWords(dictionary, word);

            System.out.println("Suggested words:" );
            for (String suggestion: suggestionsResult) {
                System.out.println(suggestion);
            }
        }










    }
}