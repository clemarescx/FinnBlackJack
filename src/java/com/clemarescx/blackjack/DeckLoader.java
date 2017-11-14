package com.clemarescx.blackjack;

import java.util.ArrayList;

/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoader {
    private Deck deck = null;

    public DeckLoader() { }

    public Deck generateOrderedDeck() {
        String[] generatedTokens = generateValidDeckTokens();
        return parseTokensToDeck(generatedTokens);
    }

    public String[] generateValidDeckTokens() {
        ArrayList<String> cardTokens = new ArrayList<>();
        for (String color : GameValues.colorSet)
            for (String face : GameValues.faceSet.keySet())
                cardTokens.add(color + face);

        return cardTokens.toArray(new String[cardTokens.size()]);
    }

    public Deck getDeck() {
        if (deck == null) {
            deck = generateOrderedDeck();
            deck.shuffle();
        }

        return deck;
    }

    public void loadTokens(String tokenString) {
        if (null == tokenString || "".equals(tokenString)) return;

        String[] tokens = tokenize(tokenString);

        if (!validForParsing(tokens))
            return;

        deck = parseTokensToDeck(tokens);
    }

    public Deck parseTokensToDeck(String[] tokens) {
        ArrayList<Card> cards = new ArrayList<>();
        for (String t : tokens) {
            String color = t.substring(0, 1);
            String face = t.substring(1);
            cards.add(new Card(color, face));
        }

        return new Deck(cards);
    }

    public boolean validForParsing(String[] tokens) {
        if (!hasValidCardCount(tokens)) {
            System.out.printf("Deck contains an invalid number of cards\n");
            System.out.printf("(found: %d, expected: 52)", tokens.length);
            return false;
        }

        if (!containsOnlyValidTokens(tokens))
            return false;
        return true;
    }

    public String[] tokenize(String tokenString) {
        return tokenString.trim().toUpperCase().split(" *, *");
    }

    private boolean hasValidCardCount(String[] tokens) {
        return tokens.length == 52;
    }

    public boolean containsOnlyValidTokens(String[] tokens) {
        for (String t : tokens) {
            if (!isValidTokenForCard(t)) {
                System.out.println(t + " is not a valid card token.");
                return false;
            }
        }
        return true;
    }

    public boolean isValidTokenForCard(String t) {
        if (t.length() < 2) return false;

        String color = t.substring(0, 1);
        String face = t.substring(1);

        return GameValues.colorSet.contains(color) && GameValues.faceSet.containsKey(face);
    }


}
