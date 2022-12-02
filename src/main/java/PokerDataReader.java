package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PokerDataReader {
    /**
     * Line example:
     * 8C TS KC 9H 4S 7D 2S 5D 3S AC
     *
     * @param filePath
     */
    public static void readData(String filePath) {
        List<Round> rounds = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(line -> {
                String[] cardNotations = line.split(" ");
                Hand firstPlayerHand = new Hand();
                Hand secondPlayerHand = new Hand();
                for (int i = 0; i < cardNotations.length; i++) {
                    String rank = String.valueOf(cardNotations[i].charAt(0));
                    String suit = String.valueOf(cardNotations[i].charAt(1));
                    Card card = new Card(
                            Rank.findByAbbreviation(rank),
                            Suit.findByAbbreviation(suit)
                    );
                    if (i <= Hand.HAND_SIZE - 1) {
                        firstPlayerHand.addCard(card);
                    } else {
                        secondPlayerHand.addCard(card);
                    }
                }
                Round round = new Round(firstPlayerHand, secondPlayerHand);
                rounds.add(round);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
