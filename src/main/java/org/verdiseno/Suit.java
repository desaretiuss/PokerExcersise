package org.verdiseno;

public enum Suit {
    CLUB("C"),
    DIAMOND("D"),
    HEART("H"),
    SPADE("S");
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
