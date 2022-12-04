package org.verdiseno.model;

public enum HandCategory {

    /**
     * Highest value card.
     */
    HIGH_CARD,

    /**
     * Two cards of the same value.
     */
    ONE_PAIR,

    /**
     * Two different pairs.
     */
    TWO_PAIR,

    /**
     * Three cards of the same value.
     */
    THREE_OF_A_KIND,

    /**
     * All cards are consecutive values.
     */
    STRAIGHT,

    /**
     * All cards of the same suit.
     */
    FLUSH,

    /**
     * Three of a kind and a pair.
     */

    FULL_HOUSE,
    /**
     * Four cards of the same value.
     */

    FOUR_OF_A_KIND,
    /**
     * All cards are consecutive values of same suit.
     */
    STRAIGHT_FLUSH,

    /**
     * Ten, Jack, Queen, King, Ace, in same suit.
     */
    ROYAL_FLUSH;
}
