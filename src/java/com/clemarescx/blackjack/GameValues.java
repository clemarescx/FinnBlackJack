package com.clemarescx.blackjack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Clem on 14/11/2017.
 */
public class GameValues {
    public final static Set<String> colorSet = new HashSet<>(Arrays.asList("C", "D", "H", "S"));
    public final static HashMap<String, Integer> faceSet = new HashMap<>();

    static {
        faceSet.put("2", 2);
        faceSet.put("3", 3);
        faceSet.put("4", 4);
        faceSet.put("5", 5);
        faceSet.put("6", 6);
        faceSet.put("7", 7);
        faceSet.put("8", 8);
        faceSet.put("9", 9);
        faceSet.put("10", 10);
        faceSet.put("J", 10);
        faceSet.put("Q", 10);
        faceSet.put("K", 10);
        faceSet.put("A", 11);
    }
}
