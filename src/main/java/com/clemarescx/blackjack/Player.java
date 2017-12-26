package com.clemarescx.blackjack;

import java.util.ArrayList;

/**
 * Created by Clem on 13/11/2017.
 */
public class Player {
    final String name;
    private final ArrayList<Card> hand;
    private final int startWinScore;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int startWinScore){
        this.name = name;
        this.startWinScore = startWinScore;
        hand = new ArrayList<>();
    }

    void addCardToHand(Card c){
        getHand().add(c);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getStartWinScore() {
        return startWinScore;
    }

}
