package com.codewithcup;

public class DeckOfCard {
    public static void main(String[] args) {
        int nofCards = 52;
        int nofPlayers = 4;
        int counter = 0;
        for (int i = 1; i <= nofCards; i++) {
            for (int j = 1; j <= nofPlayers; j++) {
                System.out.println(j);
            }
            System.out.println(i);
            counter++;

        }

        System.out.println(counter);

    }
}
