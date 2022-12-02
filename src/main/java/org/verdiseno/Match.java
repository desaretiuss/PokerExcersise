package org.verdiseno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Match {
    private Hand firstPlayerHand;
    private Hand secondPlayerHand;
}
