package com.clemarescx.blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Class to generate example decks: one "ordered" and one shuffled
 */
class Helper {
    private static final DeckLoader loader = new DeckLoader();

    public static void main(String[] args) {
        writeOrderedDeckFile();
        writeShuffledDeckFile();
    }

    // Not really "ordered" per se, but with a
    // recognisable and reoccuring pattern
    private static void writeOrderedDeckFile() {
        ArrayList<Card> orderedDeck =
                loader.generateOrderedDeck()
                        .getAvailableCards();

        writeToFile(orderedDeck, "ordered_deck.txt");
    }

    private static void writeShuffledDeckFile() {
        Deck deck = loader.generateOrderedDeck();
        deck.shuffle();
        ArrayList<Card> shuffledCards = deck.getAvailableCards();
        writeToFile(shuffledCards, "shuffled_deck.txt");
    }


    private static void writeToFile(ArrayList<Card> cards, String filepath) {
        BufferedWriter bWriter = null;
        FileWriter fWriter = null;

        String fileContent = cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));

        try {
            fWriter = new FileWriter(filepath);
            bWriter = new BufferedWriter(fWriter);
            bWriter.write(fileContent);
        } catch (IOException ex) {
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            try {
                if (bWriter != null)
                    bWriter.close();
                if (fWriter != null)
                    fWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
