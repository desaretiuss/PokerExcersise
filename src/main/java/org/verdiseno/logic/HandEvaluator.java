package org.verdiseno.logic;

import lombok.extern.log4j.Log4j2;
import org.verdiseno.model.Card;
import org.verdiseno.model.Hand;
import org.verdiseno.model.HandEvaluationData;
import org.verdiseno.model.Rank;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.verdiseno.model.HandCategory.*;
import static org.verdiseno.model.Rank.ACE;
import static org.verdiseno.model.Rank.FIVE;

@Log4j2
public class HandEvaluator {

    private HandEvaluator() {
    }

    public static HandEvaluationData evaluate(Hand hand) {
        log.info("PokerEuler -- HandEvaluator: Evaluating poker hand results");
        var isFlush = isFlush(hand.cards());
        var cardsToRankMap = groupCardsByRank(hand.cards());
        var ranks = sortRanksByFrequencyAndRankWeight(cardsToRankMap);

        if (ranks.length == 4) {
            return new HandEvaluationData(ONE_PAIR, ranks);
        } else if (ranks.length == 3) {
            return new HandEvaluationData(cardsToRankMap.get(ranks[0]) == 2 ? TWO_PAIR : THREE_OF_A_KIND, ranks);
        } else if (ranks.length == 2) {
            return new HandEvaluationData(cardsToRankMap.get(ranks[0]) == 3 ? FULL_HOUSE : FOUR_OF_A_KIND, ranks);
        } else if (ranks[0].ordinal() - ranks[4].ordinal() == 4) {
            return new HandEvaluationData(isFlush ? STRAIGHT_FLUSH : STRAIGHT, ranks[0]);
        } else if (ranks[0].equals(ACE) && ranks[1].equals(FIVE)) {// A-2-3-4-5
            return new HandEvaluationData(isFlush ? STRAIGHT_FLUSH : STRAIGHT, FIVE);
        } else {
            return new HandEvaluationData(isFlush ? FLUSH : HIGH_CARD, ranks);
        }
    }

    private static boolean isFlush(List<Card> cards) {
        return cards
                .stream()
                .map(Card::suit)
                .distinct()
                .count() == 1;
    }

    private static Map<Rank, Long> groupCardsByRank(List<Card> cards) {
        return cards
                .stream()
                .collect(groupingBy(Card::rank, counting()));
    }

    private static Rank[] sortRanksByFrequencyAndRankWeight(Map<Rank, Long> cardsToRankMap) {
        return cardsToRankMap
                .entrySet()
                .stream()
                .sorted(comparing(Map.Entry<Rank, Long>::getValue)
                        .thenComparing(Map.Entry::getKey)
                        .reversed())
                .map(Map.Entry::getKey)
                .toArray(Rank[]::new);
    }

}
