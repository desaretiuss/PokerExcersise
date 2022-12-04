package org.verdiseno.logic;

import lombok.extern.log4j.Log4j2;
import org.verdiseno.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class InputDataProcessor {

    public static List<HandResult> getResults(String filename) {
        List<HandResult> handResults = new ArrayList<>();
        InputStream inputStream = InputDataProcessor.class.getResourceAsStream(filename);
        try {
            if (inputStream == null) {
                throw new FileNotFoundException(String.format("No resource with name: %s was found", filename));
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                HandResult result = parseResultsFromStringNotations(line);
                handResults.add(result);
            }
        } catch (FileNotFoundException e) {
            log.error("File containing poker results data not found: {}", e.getMessage());
        } catch (IOException e) {
            log.error("Error while processing poker results data from file: {}", e.getMessage());
            e.printStackTrace();
        }
        return handResults;
    }

    protected static HandResult parseResultsFromStringNotations(String line) {
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
