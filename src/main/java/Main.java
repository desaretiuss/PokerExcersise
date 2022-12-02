package main.java;

public class Main {
    private static String INPUT_FILE_PATH = "C:\\MyPrograms\\PokerExercise\\src\\main\\src\\poker_hands_data.txt";

    public static void main(String[] args) {
        PokerDataReader.readData(INPUT_FILE_PATH);
        System.out.println("Hello world!");
    }
}