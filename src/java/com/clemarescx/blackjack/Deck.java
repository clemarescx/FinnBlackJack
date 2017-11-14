package com.clemarescx.blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Clem on 13/11/2017.
 */
public class Deck implements IDeck {

    private final ArrayList<Card> available;

    Deck(ArrayList<Card> cards) {
        available = cards;
    }

    @Override
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int from = rand.nextInt(available.size());
            int to = rand.nextInt(available.size());
            Card temp = available.get(from);
            available.set(from, available.get(to));
            available.set(to, temp);
        }
        for (int i = available.size() - 1; i >= 0; i--) {
            System.out.printf("%s ", available.get(i));
        }
        System.out.println();
    }

    @Override
    public Card pickTopCard() {
        return available == null || available.isEmpty() ? null : available.remove(available.size() - 1);
    }

    @Override
    public void addCard(Card c) {
        available.add(c);
    }

    ArrayList<Card> getAvailableCards() {
        return available;
    }
}
