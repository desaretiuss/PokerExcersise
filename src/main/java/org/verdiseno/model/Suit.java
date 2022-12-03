package org.verdiseno.model;

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
        for (Suit suit : values()) {
            if (suit.abbreviation.equals(abbreviation)) {
                return suit;
            }
        }
        throw new IllegalArgumentException();
    }
}
