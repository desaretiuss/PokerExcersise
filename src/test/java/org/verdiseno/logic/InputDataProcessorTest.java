package org.verdiseno.logic;

import org.junit.Test;
import org.verdiseno.model.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputDataProcessorTest {
    public static final String INPUT_TEST_DATA_FILENAME = "/poker-test.txt";

    @Test
    public void whenProcessingInputDataExpectCorrectResults() {
        List<HandResults> expectedResults = List.of(
                createHandResultsFor1stLineInFile(),
                createHandResultsFor2ndLineInFile()
        );
        List<HandResults> actualResults = InputDataProcessor.getResults(INPUT_TEST_DATA_FILENAME);
        assertEquals(actualResults, expectedResults);
    }

    private HandResults createHandResultsFor1stLineInFile() {
        Card card_8C = new Card(Rank.EIGHT, Suit.CLUBS);
        Card card_TS = new Card(Rank.TEN, Suit.SPADES);
        Card card_KC = new Card(Rank.KING, Suit.CLUBS);
        Card card_9H = new Card(Rank.NINE, Suit.HEARTS);
        Card card_4S = new Card(Rank.FOUR, Suit.SPADES);
        Card card_7D = new Card(Rank.SEVEN, Suit.DIAMONDS);
        Card card_2S = new Card(Rank.TWO, Suit.SPADES);
        Card card_5D = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card_3S = new Card(Rank.THREE, Suit.SPADES);
        Card card_AC = new Card(Rank.ACE, Suit.CLUBS);

        return new HandResults(
                new Hand(List.of(card_8C, card_TS, card_KC, card_9H, card_4S)),
                new Hand(List.of(card_7D, card_2S, card_5D, card_3S, card_AC))
        );
    }

    private HandResults createHandResultsFor2ndLineInFile() {
        Card card_5C = new Card(Rank.FIVE, Suit.CLUBS);
        Card card_AD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card_5D = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card_AC = new Card(Rank.ACE, Suit.CLUBS);
        Card card_9C = new Card(Rank.NINE, Suit.CLUBS);
        Card card_7C = new Card(Rank.SEVEN, Suit.CLUBS);
        Card card_5H = new Card(Rank.FIVE, Suit.HEARTS);
        Card card_8D = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card card_TD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card_KS = new Card(Rank.KING, Suit.SPADES);

        return new HandResults(
                new Hand(List.of(card_5C, card_AD, card_5D, card_AC, card_9C)),
                new Hand(List.of(card_7C, card_5H, card_8D, card_TD, card_KS))
        );
    }
}
