package com.clemarescx.blackjack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/**
 * Created by Clem on 13/11/2017.
 */
public class DeckLoaderTest {
    private DeckLoader loader;

    private ArrayList<String> invalidStringOfTokensList;
    private String[] validTokens;

    @Before
    public void setup(){
        loader = new DeckLoader();
        invalidStringOfTokensList =
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
        invalidStringOfTokensList = null;
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
    public void generateValidDeckTokens() {
        ArrayList<String> colors = new ArrayList<>(GameValues.colorSet);
        ArrayList<String> faces = new ArrayList<>(GameValues.faceSet.keySet());

        String firstTokenGenerated = colors.get(0) + faces.get(0);
        String lastTokenGenerated = colors.get(colors.size()-1) + faces.get(faces.size()-1);

        assertEquals(firstTokenGenerated, validTokens[0]);
        assertEquals(lastTokenGenerated, validTokens[validTokens.length-1]);
    }

    @Test
    public void cardsInGeneratedDeckContainSameValueAsToken() {
        Deck deck = loader.parseTokensToDeck(validTokens);
        List<String> comparisonList =  deck.getAvailableCards().stream()
                .map(card -> card.color + card.face)
                .filter( cardToken -> Arrays.asList(validTokens).contains(cardToken))
        .collect(Collectors.toList());
        assertEquals(comparisonList.size(), validTokens.length);
    }


    @Test
    public void tokensWithWrongFormatAreNotValidForParsing() {

        invalidStringOfTokensList.stream()
                .map( stringOfTokens -> loader.tokenize(stringOfTokens))
                .forEach( tokenList -> assertFalse(loader.validForParsing(tokenList)));
    }

    @Test
    public void correctStringListOfTokensValidForParsing() {
        assertTrue(loader.validForParsing(validTokens));
    }

    @Test
    public void generatedTokensContainsOnlyValidTokens() {
        assertTrue(loader.containsOnlyValidTokens(validTokens));
    }

    @Test
    public void isValidTokenForCard() {
        Arrays.stream(validTokens)
                .forEach(token -> assertTrue(loader.isValidCardToken(token)));
    }


}
