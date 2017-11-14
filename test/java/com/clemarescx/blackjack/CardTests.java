package com.clemarescx.blackjack;


import com.clemarescx.blackjack.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Clem on 13/11/2017.
 */
public class CardTests {

    private Card tested_card;
    @Before
    public void setup(){
        tested_card = new Card("H","J");
    }

    @After
    public void tearDown(){
        tested_card = null;
    }

    @Test
    public void sameAttributeComparison(){
        Card card_same_values = new Card("H","J");
        Card card_same_values2 = new Card(tested_card.color,tested_card.face);

        assertEquals(tested_card, card_same_values);
        assertEquals(tested_card, card_same_values2);
        assertNotEquals(new Card("D","K"),new Card("D","J"));
        assertNotEquals(new Card("D", "2"),new Card("S","2"));
    }

    @Test
    public void equalityNotByReference(){
        assertEquals(new Card("D","K"),new Card("D","K"));
    }
}
