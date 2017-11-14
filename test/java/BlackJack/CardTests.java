package BlackJack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Clem on 13/11/2017.
 */
public class CardTests {

    private static Card tested_card;
    @BeforeAll
    static void setup(){
        tested_card = new Card("H","J");
    }

    @Test
    void card_sameAttributeComparison(){
        Card card_same_values = new Card("H","J");
        Card card_same_values2 = new Card(tested_card.color,tested_card.face);

        assertEquals(tested_card, card_same_values);
        assertEquals(tested_card, card_same_values2);
        assertNotEquals(new Card("D","K"),new Card("D","J"));
        assertNotEquals(new Card("D", "2"),new Card("S","2"));
    }

    @Test
    void card_equalityNotByReference(){
        assertEquals(new Card("D","K"),new Card("D","K"));
    }
}
