package main.java;

public class Round {
    private Hand firstPlayerHand;
    private Hand secondPlayerHand;

    public Round(Hand firstPlayerHand, Hand secondPlayerHand) {
        this.firstPlayerHand = firstPlayerHand;
        this.secondPlayerHand = secondPlayerHand;
    }

    public Hand getFirstPlayerHand() {
        return firstPlayerHand;
    }

    public void setFirstPlayerHand(Hand firstPlayerHand) {
        this.firstPlayerHand = firstPlayerHand;
    }

    public Hand getSecondPlayerHand() {
        return secondPlayerHand;
    }

    public void setSecondPlayerHand(Hand secondPlayerHand) {
        this.secondPlayerHand = secondPlayerHand;
    }
}
