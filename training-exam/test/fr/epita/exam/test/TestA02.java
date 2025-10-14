package fr.epita.exam.test;

import fr.epita.exam.datamodel.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestA02 {

    public static void main(String[] args) {
        // {7 of Hearts, 3 of Spades, 5 of Diamonds, 9 of Hearts, Jack (11) of
        //Diamonds, King of Clubs(13), 6 of Clubs, Ace of Diamonds}

        List<Card> cards = new ArrayList<>(List.of(
                new Card("Hearts", 7),
                new Card("Spades", 3),
                new Card("Diamonds", 5)
                // to be continued
        ));

        cards.sort(Comparator.comparingInt(Card::getValue));

        System.out.println("sorted");
        System.out.println(cards);



    }
}
