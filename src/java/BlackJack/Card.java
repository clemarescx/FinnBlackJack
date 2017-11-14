package BlackJack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Clem on 13/11/2017.
 */
public class Card {




    public String color;
    public String face;

    Card(String color, String face) {
        this.color = color;
        this.face = face;
    }

    @Override
    public int hashCode() {
        return color.hashCode() + face.hashCode();
    }

    @Override
    public String toString() {
        return color + face;
    }

    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof Card))
            return false;
        Card other = (Card) obj;
        return this.hashCode() == other.hashCode();
    }
}
