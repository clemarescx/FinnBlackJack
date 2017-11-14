package com.clemarescx.blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Clem on 14/11/2017.
 */
public class Helper {
    private static DeckLoader loader = new DeckLoader();


    public static void writeOrderedDeckFile(){
        ArrayList<Card> orderedDeck =
                loader.generateOrderedDeck()
                        .getAvailableCards();

        writeToFile(orderedDeck, "ordered_deck.txt");
    }

    public static void writeShuffledDeckFile(){
        Deck deck = loader.generateOrderedDeck();
        deck.shuffle();
        ArrayList<Card> shuffledCards = deck.getAvailableCards();
        writeToFile(shuffledCards, "shuffled_deck.txt");
    }

    public static void main(String[] args) {
        writeOrderedDeckFile();
        writeShuffledDeckFile();
    }

    private static void writeToFile(ArrayList<Card> cards, String filepath){
        BufferedWriter bwriter = null;
        FileWriter  fwriter = null; ;

        String fileContent = cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));

        try{
            fwriter = new FileWriter(filepath);
            bwriter = new BufferedWriter( fwriter);
            bwriter.write(fileContent);
        } catch (IOException ex){
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            try {
                if(bwriter != null)
                    bwriter.close();
                if(fwriter != null)
                    fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
