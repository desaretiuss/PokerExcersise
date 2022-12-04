package org.verdiseno.model;

import java.util.Arrays;

public enum Suit {

    DIAMONDS("D"),
    CLUBS("C"),
    HEARTS("H"),
    SPADES("S");
    private final String abbreviation;

    Suit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Suit findByAbbreviation(String abbreviation) {
        return Arrays.stream(values())
                .filter(suit -> suit.abbreviation.equals(abbreviation))
                .findFirst()
                .orElseThrow();
    }
}
