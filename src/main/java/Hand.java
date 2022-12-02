package main.java;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    public static int HAND_SIZE = 5;
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
