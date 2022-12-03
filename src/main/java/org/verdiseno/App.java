package org.verdiseno;

import org.verdiseno.model.HandResults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        List<HandResults> handResults = InputDataProcessor.getResults();
        long handsWonByFirstPlayer = handResults.stream()
                .filter(results -> isFirstPlayerWinner(results))
                .count();
        System.out.println("--------- Poker Results ---------");
        System.out.println("---------------------------------");
        System.out.println("Hands won by First Player: " + handsWonByFirstPlayer);
    }

    protected static boolean isFirstPlayerWinner(HandResults results) {
        Set firstPlayerCards = new HashSet(results.firstPlayerHand().cards());
        Set secondPlayerCards = new HashSet(results.secondPlayerHand().cards());
        HandEvaluated firstPlayerHandEvaluated = HandEvaluated.evaluate(firstPlayerCards);
        HandEvaluated secondPlayerHandEvaluated = HandEvaluated.evaluate(secondPlayerCards);
        return firstPlayerHandEvaluated.compareTo(secondPlayerHandEvaluated) > 0;
    }
}