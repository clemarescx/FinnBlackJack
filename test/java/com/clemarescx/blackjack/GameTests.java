package com.clemarescx.blackjack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by Clem on 13/11/2017.
 */
public class GameTests {

    DeckLoader loader;


    /**
     * REMEMBER:
     */
    @Before
    public void setup(){
        loader = new DeckLoader();

    }

    @After
    public void tearDown(){
        loader = null;
    }

    @Test
    public void SamWinsIfBothPlayersStartWith21(){
        String[] tokens = loader.tokenize("H10,HJ,HQ,SK,HK,CK,DA,SA");
        Arrays.asList(tokens).forEach(c -> System.out.printf("%s ", c));
        String reversed = Arrays.stream(tokens)
                .reduce( "", (current, total)->  total +", " + current);
        System.out.println("Reversed: " + reversed);

        Deck deck = loader.parseTokensToDeck(tokens);
        Game game = new Game(deck);
        game.setup();
        game.run();
        Player winner = game.getWinner();
        game.printScores();
        assertTrue(winner.name.trim().toLowerCase().equals("sam"));
    }

    @Test
    public void DealerWinsIfBothPlayersStartWith22(){
        String[] tokens = loader.tokenize("CK,HK,DK,SK,CA,HA,DA,SA");
        Deck deck = loader.parseTokensToDeck(tokens);
        Game game = new Game(deck);
        game.setup();
        game.run();
        Player winner = game.getWinner();
        assertTrue(winner.name.trim().toLowerCase().equals("dealer"));
    }


}
