package org.verdiseno.logic;

import lombok.extern.log4j.Log4j2;
import org.verdiseno.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class InputDataProcessor {

    private InputDataProcessor() {
    }

    public static List<HandResult> processInputData(String filename) {
        return readDataInputFile(filename)
                .stream()
                .map(InputDataProcessor::parseResultFromStringNotations)
                .toList();
    }

    private static List<String> readDataInputFile(String filename) {
        log.info("PokerEuler -- InputDataProcessor: Reading data input...");
        InputStream inputStream = InputDataProcessor.class.getClassLoader().getResourceAsStream(filename);
        try {
            if (inputStream == null) {
                throw new FileNotFoundException(String.format("No resource file with name: %s was found", filename));
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.lines().toList();
        } catch (IOException e) {
            log.error("Error while processing poker results data from file: {}", e.getMessage());
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    protected static HandResult parseResultFromStringNotations(String line) {
        log.info("PokerEuler -- InputDataProcessor: Parsing results");
        List<Card> cards = new ArrayList<>();
        String[] cardNotations = line.split(" ");
        for (String cardNotation : cardNotations) {
            String rank = String.valueOf(cardNotation.charAt(0));
            String suit = String.valueOf(cardNotation.charAt(1));
            Card card = new Card(
                    Rank.findByAbbreviation(rank),
                    Suit.findByAbbreviation(suit)
            );
            cards.add(card);
        }
        Hand firstPlayerHand = new Hand(cards.subList(0, 5));
        Hand secondPlayerHand = new Hand(cards.subList(5, 10));
        return new HandResult(firstPlayerHand, secondPlayerHand);
    }
}
