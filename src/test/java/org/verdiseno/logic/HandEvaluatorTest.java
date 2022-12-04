package org.verdiseno.logic;

import org.junit.Before;
import org.junit.Test;
import org.verdiseno.model.HandEvaluationData;
import org.verdiseno.model.HandResult;
import util.ResultInfo;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.verdiseno.logic.InputDataProcessor.parseResultsFromStringNotations;
import static org.verdiseno.model.HandCategory.*;

public class HandEvaluatorTest {

    private List<HandResult> results;
    private List<ResultInfo> expectedResultInfos;

    @Before
    public void setup() {
        results = List.of(
                parseResultsFromStringNotations("5H 5C 6S 7S KD 2C 3S 8S 8D TD"),
                parseResultsFromStringNotations("5D 8C 9S JS AC 2C 5C 7D 8S QH"),
                parseResultsFromStringNotations("2D 9C AS AH AC 3D 6D 7D TD QD"),
                parseResultsFromStringNotations("4D 6S 9H QH QC 3D 6D 7H QD QS"),
                parseResultsFromStringNotations("2H 2D 4C 4D 4S 3C 3D 3S 9S 9D")
        );

        expectedResultInfos = List.of(
                new ResultInfo(ONE_PAIR, ONE_PAIR, 2),
                new ResultInfo(HIGH_CARD, HIGH_CARD, 1),
                new ResultInfo(THREE_OF_A_KIND, FLUSH, 2),
                new ResultInfo(ONE_PAIR, ONE_PAIR, 1),
                new ResultInfo(FULL_HOUSE, FULL_HOUSE, 1)
        );
    }

    @Test
    public void whenEvaluatingHandsExpectCorrectResults() {
        List<ResultInfo> actualResultInfos = results.stream().map(entry -> {
            HandEvaluationData firstPlayerEvaluationData = HandEvaluator.evaluate(entry.firstPlayerHand());
            HandEvaluationData secondPlayerEvaluationData = HandEvaluator.evaluate(entry.secondPlayerHand());
            return new ResultInfo(
                    firstPlayerEvaluationData.handCategory(),
                    secondPlayerEvaluationData.handCategory(),
                    firstPlayerEvaluationData.compareTo(secondPlayerEvaluationData) > 0 ? 1 : 2
            );
        }).collect(Collectors.toList());
        assertEquals(actualResultInfos, expectedResultInfos);
    }
}
