package BlackJack;

import java.util.Collection;

/**
 * Created by Clem on 13/11/2017.
 */
public interface IDeck {
    public void shuffle();
    public Card pickTopCard();
    public boolean isEmpty();
    public void reset();

    void addCard(Card c);

    void addCards(Collection<Card> cards);
}
