package BlackJack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoaderTests {
    private static DeckLoader loader;
    private static String whitespaceTest = "H4, h4  , H4,H4,H4,h4";
    @BeforeAll
    static void setup(){
        loader = new DeckLoader();
    }

    @Test
    void deckloader_tokenize(){
        String[] tokens = loader.tokenize(whitespaceTest);
        for (String token : tokens) {
          assertEquals(token, "H4");
        }

    }

}
