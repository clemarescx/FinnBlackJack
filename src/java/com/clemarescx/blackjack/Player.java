package com.clemarescx.blackjack;

import java.util.ArrayList;

/**
 * Created by Clem on 13/11/2017.
 */
public class Player {
    String name;
    ArrayList<Card> hand;
    private int startWinScore;

    public Player(String name, int startWinScore){
        this.name = name;
        this.startWinScore = startWinScore;
        hand = new ArrayList<Card>();
    }

    protected void addCardToHand(Card c){
        getHand().add(c);
    }

    protected void resetHand(){
        getHand().clear();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getStartWinScore() {
        return startWinScore;
    }
}
