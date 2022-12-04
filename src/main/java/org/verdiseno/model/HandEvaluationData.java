package org.verdiseno.model;

import java.util.Arrays;

import static java.util.Comparator.comparing;

public record HandEvaluationData(HandCategory handCategory, Rank... ranks) implements Comparable<HandEvaluationData> {

    public int compareTo(HandEvaluationData that) {
        return comparing(HandEvaluationData::handCategory)
                .thenComparing(HandEvaluationData::ranks, Arrays::compare)
                .compare(this, that);
    }
}