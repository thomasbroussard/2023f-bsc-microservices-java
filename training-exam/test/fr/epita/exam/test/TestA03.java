package fr.epita.exam.test;

import fr.epita.exam.datamodel.Card;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestA03 {

    public static void main(String[] args) {
        Map<String, List<Card>> cardsByColor = new LinkedHashMap<>();
        List<Card> cards = new ArrayList<>(List.of(
                new Card("Hearts", 7),
                new Card("Spades", 3),
                new Card("Diamonds", 5)
                // to be continued
        ));

        //A. this is equivalent to B.
        for (Card card : cards) {
            List<Card> currentList = cardsByColor.computeIfAbsent(card.getColor(), k -> new ArrayList<>());
            currentList.add(card);
        }

        //B. stream api
        cardsByColor = cards.stream().collect(Collectors.groupingBy(Card::getColor));

        System.out.println(cardsByColor);
    }
}
