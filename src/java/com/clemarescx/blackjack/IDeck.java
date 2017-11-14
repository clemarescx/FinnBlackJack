package com.clemarescx.blackjack;

import java.util.Collection;

/**
 * Created by Clem on 13/11/2017.
 */
public interface IDeck {
    public void shuffle();

    public Card pickTopCard();

    void addCard(Card c);
}
