package org.verdiseno;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Match> matches = PokerResults.getResults();
        System.out.println("Hello world!");
    }
}