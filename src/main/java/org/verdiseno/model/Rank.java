package org.verdiseno.model;

import java.util.Arrays;

public enum Rank {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");
    private final String abbreviation;

    Rank(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Rank findByAbbreviation(String abbreviation) {
        return Arrays.stream(values())
                .filter(rank -> rank.abbreviation.equals(abbreviation))
                .findFirst()
                .orElseThrow();
    }
}
