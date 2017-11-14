package BlackJack;

import java.util.ArrayList;

/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoader {
    private Deck deck = null;
    String tokenList;

    public DeckLoader() {    }

    private Deck generateDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for(String color : GameValues.colorSet)
        for(String face : GameValues.faceSet.keySet())
            cards.add(new Card(color,face));
        Deck generatedDeck = new Deck(cards);
        generatedDeck.shuffle();
        return generatedDeck;
    }

    public Deck getDeck() {
        if(deck == null)
            deck = generateDeck();
        return deck;
    }

    public void loadTokens(String tokenString) {
        if(null == tokenString || "".equals(tokenString) ) return;

        String[] tokens = tokenize(tokenString);

        if(!validForParsing(tokens))
            return;

        deck = parseTokensToDeck(tokens);

    }

    public Deck parseTokensToDeck(String[] tokens) {
        ArrayList<Card> cards = new ArrayList<>();
        for(String t : tokens){
            String color = t.substring(0,1);
            String face = t.substring(1);
            cards.add(new Card(color,face));
        }

        return new Deck(cards);
    }

    private boolean validForParsing(String[] tokens) {
        if(!hasValidCardCount(tokens)){
            System.out.printf("Deck contains an invalid number of cards\n");
            System.out.printf("(found: %d, expected: 52)",tokens.length);
            return false;
        }

        if(!containsOnlyValidTokens(tokens))
            return false;
        return true;
    }

    public String[] tokenize(String tokenString) {
        return tokenString.trim().toUpperCase().split(" *, *");
    }

    private boolean hasValidCardCount(String[] tokens) {
        return tokens.length == 52;
    }

    public boolean containsOnlyValidTokens(String[] tokens){
        for(String t : tokens){
            if (!isValidTokenForCard(t)){
                System.out.println(t + " is not a valid card token.");
                return false;
            }
        }
        return true;
    }

    private boolean isValidTokenForCard(String t) {
        if(t.length() < 2) return false;

        String color = t.substring(0,1);
        String face = t.substring(1);

        return GameValues.colorSet.contains(color) && GameValues.faceSet.containsKey(face);
    }


}
