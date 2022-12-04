package util;

import org.verdiseno.model.HandCategory;

public record ResultInfo(HandCategory firstPlayerHandCategory, HandCategory secondPlayerHandCategory,
                         int winningPlayer) {
}