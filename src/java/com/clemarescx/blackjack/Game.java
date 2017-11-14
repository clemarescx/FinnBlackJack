package com.clemarescx.blackjack;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Clem on 13/11/2017.
 */
class Game {
    private IDeck deck;
    private Player sam, dealer, winner;
    private Player[] players;

    Game(IDeck deck) {
        this.deck = deck;
    }

    public Game() {
        this.deck = new Deck(new ArrayList<>());
//        setup();
    }

    public void setup() {
        sam = new Player("sam", 21);
        dealer = new Player("dealer", 22);
        players = new Player[]{sam, dealer};
        for (int i = 0; i < 2; i++) {
            for (Player p : players)
                p.addCardToHand(deck.pickTopCard());
        }

    }

    /**
     * main game "loop" (only runs once)
     */
    void run() {

        if (wonBeforeStart()) return;

        pickCardsWhileUnderTargetScore(sam, 17);

        if (getScore(sam) > 21) {
            winner = dealer;
            return;
        }

        pickCardsWhileUnderTargetScore(dealer, getScore(sam) + 1);

        if (getScore(dealer) > 21)
            winner = sam;
        else
            winner = dealer;
    }

    private void pickCardsWhileUnderTargetScore(Player player, int target) {
        while (getScore(player) < target)
            player.addCardToHand(deck.pickTopCard());
    }


    private boolean wonBeforeStart() {
        for (Player p : players) {
            if (playerWonOnFirstDraw(p)) {
                winner = p;
                return true;
            }
        }
        return false;
    }

    private boolean playerWonOnFirstDraw(Player p) {
        Player other = getOpponent(p);
        return getScore(p) == p.getStartWinScore() && getScore(p) == getScore(other);
    }

    int getScore(Player p) {
        return p.getHand().stream()
                .mapToInt(card -> GameValues.getFaceValue(card.face))
                .sum();
    }

    private Player getOpponent(Player p) {
        if (p.equals(sam))
            return dealer;
        return sam;
    }

    void printScores() {
        System.out.println(winner.name);
        for (Player p : players) {
            String gameHandHistory = p.getHand().stream()
                    .map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.printf("%s: %s (score: %d)\n", p.name, gameHandHistory, getScore(p));
        }
    }

    /**
     * Methods used in tests
     */
    public Player getWinner() {
        return winner;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player getSam() {
        return sam;
    }

    public Player getDealer() {
        return dealer;
    }
}