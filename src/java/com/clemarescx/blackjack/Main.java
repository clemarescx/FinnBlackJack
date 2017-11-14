package com.clemarescx.blackjack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Clem on 11/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Finn BlackJack!");

        DeckLoader loader = new DeckLoader();
        if (args.length > 0) {
            String tokenString = loadFileContents(args[0]);
            loader.loadTokens(tokenString);
        }


        Game game = new Game(loader.getDeck());
        game.start();

    }

    private static String loadFileContents(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(52 * 4); // expected 52 cards * 4 chars per token
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return stringBuilder.toString();
    }
}
