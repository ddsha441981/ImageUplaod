package com.codewithcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class shuffleCards{

    public static void main(String[] args) {

        String[] cardsType ={"club","spade","heart","diamond"};
        String [] cardValue = {"Ace","2","3","4","5","6","7","8","9","10","King", "Queen", "Jack" };

        List<String> cards = new ArrayList<String>();
        for(int i=0;i<=(cardsType.length)-1;i++){
            for(int j=0;j<=(cardValue.length)-1;j++){
                cards.add(cardsType[i] + " " + "of" + " " + cardValue[j]) ;
            }
        }

        Collections.shuffle(cards);
        System.out.print("Enter the number of cards within:" + cards.size() + " = ");

        Scanner data = new Scanner(System.in);
        Integer inputString = data.nextInt();
        for(int l=0;l<= inputString -1;l++){
            System.out.print( cards.get(l)) ;
        }
    }
}
