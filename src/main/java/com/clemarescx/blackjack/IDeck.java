package com.clemarescx.blackjack;


/**
 * Created by Clem on 13/11/2017.
 */
interface IDeck {
    void shuffle();

    Card pickTopCard();

    void addCard(Card c);
}
