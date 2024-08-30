
import services.SpellCheck;
import java.io.File;


public class App {
    public static void main(String[] args) {

        // Check that files can be found

        //FileManager fileManager = new FileManager();
        File dictionary = new File(args[0]);
        File fileToCheck = new File(args[1]);

        SpellCheck checker = new SpellCheck();
        checker.findMisspelledWords(dictionary, fileToCheck);






    }
}