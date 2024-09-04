import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import services.SurroundingContext;
import java.io.File;



public class SurroundingContextTest {

    @Test
    void findContext_returnsDifferentiatedWithSurroundingWords() {
        SurroundingContext surroundingContext = new SurroundingContext();
        File file = new File("src/file-to-check.txt");

        String word = "differentiated";
        String result = surroundingContext.findContext(file, word);

        String expected = "are most easily differentiated based";

        assertEquals(expected, result);
    }

    @Test
    void findContext_returnsKeeepWithSurroundingWords() {
        SurroundingContext surroundingContext = new SurroundingContext();
        File file = new File("src/file-to-check.txt");
        String word = "keeep";

        String result = surroundingContext.findContext(file, word);
        String expected = "What if I keeep adding lines like ";

        assertEquals(expected, result);
    }

    @Test
    void findContext_returnsPertainsWithSurroundingWords() {
        SurroundingContext surroundingContext = new SurroundingContext();
        File file = new File("src/file-to-check.txt");

        String word = "pertains";

        String result = surroundingContext.findContext(file, word);

        String expected = "leisure. As it pertains to food production, ";


        assertEquals(expected, result);
    }

    @Test
    void findContext_returnsShorteWithSurroundingWords() {
        SurroundingContext surroundingContext = new SurroundingContext();
        File file = new File("src/file-to-check.txt");

        String word = "shorte";

        String result = surroundingContext.findContext(file, word);

        String expected = "What if its shorte?";


        assertEquals(expected, result);
    }



}
