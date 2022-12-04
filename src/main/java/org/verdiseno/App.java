package org.verdiseno;

import org.verdiseno.logic.HandEvaluator;
import org.verdiseno.logic.InputDataProcessor;
import org.verdiseno.model.HandEvaluationData;
import org.verdiseno.model.HandResults;

import java.util.List;

public class App {
    public static final String INPUT_DATA_FILENAME = "/poker.txt";

    public static void main(String[] args) {
        List<HandResults> handResults = InputDataProcessor.getResults(INPUT_DATA_FILENAME);
        long handsWonByFirstPlayer = handResults.stream()
                .filter(results -> isFirstPlayerWinner(results))
                .count();
        System.out.println("--------- Poker Results ---------");
        System.out.println("---------------------------------");
        System.out.println("Hands won by First Player: " + handsWonByFirstPlayer);
    }

    public static boolean isFirstPlayerWinner(HandResults results) {
        HandEvaluationData firstPlayerEvaluationData = HandEvaluator.evaluate(results.firstPlayerHand());
        HandEvaluationData secondPlayerEvaluationData = HandEvaluator.evaluate(results.secondPlayerHand());
        return firstPlayerEvaluationData.compareTo(secondPlayerEvaluationData) > 0;
    }
}