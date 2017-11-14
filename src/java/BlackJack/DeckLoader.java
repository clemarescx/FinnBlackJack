package BlackJack;

/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoader {
    private Deck deck = null;
    String tokenList;

    public DeckLoader() {    }

    private Deck generateDeck() {
        Deck generatedDeck = new Deck();

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

    private Deck parseTokensToDeck(String[] tokens) {
        return null;
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
