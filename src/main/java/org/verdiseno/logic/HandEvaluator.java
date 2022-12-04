package org.verdiseno.logic;

import org.verdiseno.model.Card;
import org.verdiseno.model.Hand;
import org.verdiseno.model.HandEvaluationData;
import org.verdiseno.model.Rank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.verdiseno.model.HandCategory.*;
import static org.verdiseno.model.Rank.ACE;
import static org.verdiseno.model.Rank.FIVE;

public class HandEvaluator {

    public static HandEvaluationData evaluate(Hand hand) {
        Set<Card> cards = new HashSet<>(hand.cards());
        if (cards.size() != 5) {
            throw new IllegalArgumentException();
        }
        var flush = isFlush(cards);
        var counts = groupCardsByRank(cards);
        var ranks = getRanksSorted(counts);

        if (ranks.length == 4) {
            return new HandEvaluationData(ONE_PAIR, ranks);
        } else if (ranks.length == 3) {
            return new HandEvaluationData(counts.get(ranks[0]) == 2 ? TWO_PAIR : THREE_OF_A_KIND, ranks);
        } else if (ranks.length == 2) {
            return new HandEvaluationData(counts.get(ranks[0]) == 3 ? FULL_HOUSE : FOUR_OF_A_KIND, ranks);
        } else if (ranks[0].ordinal() - ranks[4].ordinal() == 4) {
            return new HandEvaluationData(flush ? STRAIGHT_FLUSH : STRAIGHT, ranks[0]);
        } else if (ranks[0].equals(ACE) && ranks[1].equals(FIVE)) { // A-2-3-4-5
            return new HandEvaluationData(flush ? STRAIGHT_FLUSH : STRAIGHT, FIVE);
        } else {
            return new HandEvaluationData(flush ? FLUSH : HIGH_CARD, ranks);
        }
    }

    private static boolean isFlush(Set<Card> cards) {
        return cards
                .stream()
                .map(Card::suit)
                .distinct()
                .count() == 1;
    }

    private static Map<Rank, Long> groupCardsByRank(Set<Card> cards) {
        return cards
                .stream()
                .collect(groupingBy(Card::rank, counting()));
    }

    private static Rank[] getRanksSorted(Map<Rank, Long> counts) {
        return counts
                .entrySet()
                .stream()
                .sorted(comparing(Map.Entry<Rank, Long>::getValue)
                        .thenComparing(Map.Entry::getKey)
                        .reversed())
                .map(Map.Entry::getKey)
                .toArray(Rank[]::new);
    }

}
