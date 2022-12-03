package org.verdiseno;

import java.util.List;

public class Hand {

    public static int HAND_SIZE = 5;
    private List<Card> cards;

    public Hand(List<Card> cards) {
        if (cards == null || cards.size() != HAND_SIZE) {
            throw new IllegalArgumentException("Hand must contain exactly five cards!");
        }
        this.cards = cards;
    }



}
