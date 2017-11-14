package com.clemarescx.blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Clem on 13/11/2017.
 */
public class Deck implements IDeck {

    private ArrayList<Card> available;
    private ArrayList<Card> picked;

    public Deck(ArrayList<Card> cards) {
        available = cards;
        picked = new ArrayList<Card>();
    }

    @Override
    public void shuffle() {
        for(int i =0; i < 1000; i++){
            Random rand = new Random();
            int from = rand.nextInt(available.size());
            int to = rand.nextInt(available.size());
            Card temp = available.get(from);
            available.set(from, available.get(to));
            available.set(to, temp);
        }
    }

    @Override
    public Card pickTopCard() {
        Card pickedCard = available.remove(available.size()-1);
        picked.add(pickedCard);
        return pickedCard;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    /**
     * Puts the picked cards back at the "bottom" of the available pile
     * in the same order they were picked out, and empties the "picked" stash
     */
    public void reset() {
        // put the picked cards back at the "bottom" of the available pile
        // in the same order they were picked
        picked.forEach( card -> available.add(0,card));
        picked.clear();
    }
    @Override
    public void addCard(Card c){
        available.add(c);
    }

    @Override
    public void addCards(Collection<Card> cards){
        for(Card c : cards)
            addCard(c);
    }

    public ArrayList<Card> getAvailableCards(){
        return available;
    }
}
