package com.clemarescx.blackjack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Clem on 13/11/2017.
 */
public class GameTest {

    private DeckLoader loader;
    private Game game;


    @Before
    public void setup(){
        loader = new DeckLoader();
        game = new Game();

    }

    @After
    public void tearDown(){
        loader = null;
        game = null;
    }

    @Test
    public void SamWinsIfBothPlayersStartWithScore21() {
        Deck deck = getDeckFromValidStringOfTokens("HK,CK,DA,SA,H10,HJ,HQ,SK");

        game.setDeck(deck);
        game.setup();
        game.run();
        Player winner = game.getWinner();

        assertTrue(winner.name.trim().toLowerCase().equals("sam"));
        assertTrue(game.getScore(game.getDealer()) == 21);
        assertEquals(game.getScore(game.getSam()), game.getScore(game.getDealer()));

    }

    @Test
    public void DealerWinsIfBothPlayersStartWithScore22() {
        Deck deck = getDeckFromValidStringOfTokens("CA,HA,DA,SA,CK,HK,DK,SK");

        game.setDeck(deck);
        game.setup();
        game.run();
        Player winner = game.getWinner();

        assertTrue(winner.name.trim().toLowerCase().equals("dealer"));
        assertTrue(game.getScore(game.getDealer()) == 22);
        assertEquals(game.getScore(game.getSam()), game.getScore(game.getDealer()));
    }

    @Test
    public void getScoreGivesExpectedScore() {
        Deck deck = getDeckFromValidStringOfTokens("CA,HA,DA");
        Player p = new Player("scoreTest_player");
        for (Card c : deck.getAvailableCards())
            p.addCardToHand(c);
        assertEquals(p.getHand().size(), 3);
        assertEquals(game.getScore(p), 33); // 3x aces: 11 x 3
    }

    // local helper method
    private Deck getDeckFromValidStringOfTokens(String tokenString) {
        String[] tokens = loader.tokenize(tokenString);
        tokens = loader.reverseTokenOrder(tokens);
        return loader.parseTokensToDeck(tokens);
    }

}
