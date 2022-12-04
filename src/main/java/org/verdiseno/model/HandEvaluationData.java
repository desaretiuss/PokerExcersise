package org.verdiseno.model;

import java.util.Arrays;

import static java.util.Comparator.comparing;

public record HandEvaluationData(HandRanking handRanking, Rank... ranks) implements Comparable<HandEvaluationData> {

    public int compareTo(HandEvaluationData that) {
        return comparing(HandEvaluationData::handRanking)
                .thenComparing(HandEvaluationData::ranks, Arrays::compare)
                .compare(this, that);
    }
}