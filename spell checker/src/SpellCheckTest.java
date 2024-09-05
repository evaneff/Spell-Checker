import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import services.SpellCheck;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SpellCheckTest {

    @Test
    void findMisspelledWords_returnsAllMisspelledWords() {
        SpellCheck spellCheck = new SpellCheck();
        File dictionary = new File("src/dictionary.txt");
        File fileToCheck = new File("src/file-to-check.txt");
        List<String> result = spellCheck.findMisspelledWords(dictionary, fileToCheck);
        List<String> expected = new ArrayList<>();
        expected.add("dificult");
        expected.add("gooods");
        expected.add("importent");
        expected.add("keeep");
        expected.add("shorte");

        assertEquals(expected, result);
    }

}
