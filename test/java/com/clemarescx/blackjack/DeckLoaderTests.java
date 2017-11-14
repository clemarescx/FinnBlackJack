package com.clemarescx.blackjack;

import com.clemarescx.blackjack.DeckLoader;
import com.clemarescx.blackjack.GameValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoaderTests {
    private DeckLoader loader;

    private ArrayList<String> invalidLists;
    private String[] validTokens;

    @Before
    public void setup(){
        loader = new DeckLoader();
        invalidLists =
                new ArrayList<>(Arrays.asList(
                        "H4, B4",
                        "H4, B11",
                        "H4; H5",
                        "H4,H4"
                ));
        validTokens = loader.generateValidDeckTokens();
    }

    @After
    public void tearDown(){
        loader = null;
        invalidLists = null;
        validTokens = null;
    }

    @Test
    public void tokenizeToUppercaseWithoutWhitespaces(){
        String whitespaceTest = "H4, h4  , H4,H4,H4,h4";
        String wrongSeparator = "H4; h4  , H4,H4,H4,h4";

        String[] whitespace_tokens = loader.tokenize(whitespaceTest);
        String[] wrong_tokens = loader.tokenize(wrongSeparator);
        assertTrue(Arrays.stream(whitespace_tokens).allMatch("H4"::equals));
        assertFalse(Arrays.stream(wrong_tokens).allMatch("H4"::equals));
    }

    @Test
    public void generateDeck() {
    }

    @Test
    public void generateValidDeckTokens() {
        ArrayList<String> colors = new ArrayList<>(GameValues.colorSet);
        ArrayList<String> faces = new ArrayList<>(GameValues.faceSet.keySet());

        String firstTokenGenerated = colors.get(0) + faces.get(0);
        String lastTokenGenerated = colors.get(colors.size()-1) + faces.get(faces.size()-1);

        assertEquals(firstTokenGenerated, validTokens[0]);
        assertEquals(lastTokenGenerated, validTokens[validTokens.length-1]);
    }

    @Test
    public void parseTokensToDeck() {
    }

    @Test
    public void validForParsing() {
    }

    @Test
    public void tokenize() {
    }

    @Test
    public void containsOnlyValidTokens() {

        assertTrue(loader.containsOnlyValidTokens(validTokens));
    }

    @Test
    public void isValidTokenForCard() {
        Arrays.stream(validTokens)
                .forEach(token -> assertTrue(loader.isValidTokenForCard(token)));
    }


}
