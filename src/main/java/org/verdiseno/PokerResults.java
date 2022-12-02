package org.verdiseno;

import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PokerResults {
    public static final String FILENAME = "/poker.txt";

    public static List<Match> getResults() {
        List<Match> matches = new ArrayList<>();
        InputStream inputStream = PokerResults.class.getResourceAsStream(FILENAME);
        try {
            if (inputStream == null) {
                throw new FileNotFoundException(String.format("No resource with name: %s was found", FILENAME));
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                List<Card> cards = parseCardsFromStringNotations(line);
                Hand firstPlayerHand = new Hand(cards.subList(0, 5));
                Hand secondPlayerHand = new Hand(cards.subList(5, 10));
                matches.add(new Match(firstPlayerHand, secondPlayerHand));
            }
        } catch (FileNotFoundException e) {
            log.error("File containing poker results data not found: {}", e.getMessage());
        } catch (IOException e) {
            log.error("Error while processing poker results data from file: {}", e.getMessage());
            e.printStackTrace();
        }
        return matches;
    }

    private static List<Card> parseCardsFromStringNotations(String line) {
        List<Card> cards = new ArrayList<>();
        String[] cardNotations = line.split(" ");
        for (int i = 0; i < cardNotations.length; i++) {
            String rank = String.valueOf(cardNotations[i].charAt(0));
            String suit = String.valueOf(cardNotations[i].charAt(1));
            Card card = new Card(
                    Rank.findByAbbreviation(rank),
                    Suit.findByAbbreviation(suit)
            );
            cards.add(card);
        }
        return cards;
    }
}
