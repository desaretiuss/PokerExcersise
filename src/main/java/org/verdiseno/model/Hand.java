package org.verdiseno.model;

import org.verdiseno.config.PropertiesLoader;

import java.util.List;
import java.util.Properties;

public record Hand(List<Card> cards) {

    private static final String HAND_SIZE_LIMIT = "poker.hand.size.limit";

    public Hand {
        Properties conf = PropertiesLoader.loadProperties();
        int handSize = Integer.parseInt(conf.getProperty(HAND_SIZE_LIMIT));

        if (cards.size() != handSize) {
            throw new IllegalArgumentException("Hand must contain exactly 5 cards.");
        }
    }
}
