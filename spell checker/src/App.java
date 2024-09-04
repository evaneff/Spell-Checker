
import services.SpellCheck;
import services.SuggestedWords;
import services.SurroundingContext;

import java.io.File;
import java.util.List;


public class App {
    public static void main(String[] args) {

        SurroundingContext context = new SurroundingContext();
        SuggestedWords suggestions = new SuggestedWords();

        // Check that files can be found

        //FileManager fileManager = new FileManager();
        File dictionary = new File(args[0]);
        File fileToCheck = new File(args[1]);

        SpellCheck checker = new SpellCheck();

        List<String> misspelledWords = checker.findMisspelledWords(dictionary, fileToCheck);

        for (String word: misspelledWords) {
            System.out.println("\nmisspelled word: " + word);
            //find surrounding context
            String contextResult = context.findContext(fileToCheck, word);

            System.out.println("context: " + contextResult);

            //find suggested words
            List<String> suggestionsResult = suggestions.suggestWords(dictionary, word);

            System.out.println("Suggested words:" );
            for (String suggestion: suggestionsResult) {
                System.out.println(suggestion);
            }
        }










    }
}