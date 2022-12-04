package org.verdiseno.logic;

import org.junit.Before;
import org.junit.Test;
import org.verdiseno.App;
import org.verdiseno.model.Card;
import org.verdiseno.model.Hand;
import org.verdiseno.model.HandResults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HandEvaluatorTest {

    private Map<String, Integer> demoValuesMap = new HashMap<>();

    @Before
    public void setup() {
        demoValuesMap.put("5H 5C 6S 7S KD 2C 3S 8S 8D TD", 2);
        demoValuesMap.put("5D 8C 9S JS AC 2C 5C 7D 8S QH", 1);
        demoValuesMap.put("2D 9C AS AH AC 3D 6D 7D TD QD", 2);
        demoValuesMap.put("4D 6S 9H QH QC 3D 6D 7H QD QS", 1);
        demoValuesMap.put("2H 2D 4C 4D 4S 3C 3D 3S 9S 9D", 1);
    }

    @Test
    public void whenEvaluatingHandsExpectCorrectWinners() {
        List<Integer> expectedWinners = demoValuesMap.values().stream().toList();
        List<Integer> actualWinners = demoValuesMap.entrySet().stream().map(entry -> {
            List<Card> allCards = InputDataProcessor.parseCardsFromStringNotations(entry.getKey());
            HandResults handResults = new HandResults(
                    new Hand(allCards.subList(0, 5)),
                    new Hand(allCards.subList(5, 10))
            );
            return App.isFirstPlayerWinner(handResults) ? 1 : 2;
        }).collect(Collectors.toList());
        assertEquals(actualWinners, expectedWinners);
    }
}
