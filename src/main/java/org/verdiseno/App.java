package org.verdiseno;

import org.verdiseno.config.PropertiesLoader;
import org.verdiseno.logic.HandEvaluator;
import org.verdiseno.logic.InputDataProcessor;
import org.verdiseno.model.HandEvaluationData;

import java.util.Properties;

public class App {
    private static final String POKER_DATA_INPUT_FILENAME = "poker.data.input.filename";

    public static void main(String[] args) {
        System.out.println("--------- Poker Results ---------");
        System.out.println("---------------------------------");
        System.out.println("Hands won by First Player: " + calculateHandsWonByFirstPlayer());
    }

    public static long calculateHandsWonByFirstPlayer() {
        Properties conf = PropertiesLoader.loadProperties();
        String filename = conf.getProperty(POKER_DATA_INPUT_FILENAME);

        return InputDataProcessor
                .processInputData(filename)
                .stream()
                .filter(result -> {
                    HandEvaluationData firstPlayerEvaluationData = HandEvaluator.evaluate(result.firstPlayerHand());
                    HandEvaluationData secondPlayerEvaluationData = HandEvaluator.evaluate(result.secondPlayerHand());
                    return firstPlayerEvaluationData.compareTo(secondPlayerEvaluationData) > 0;
                }).count();

    }
}