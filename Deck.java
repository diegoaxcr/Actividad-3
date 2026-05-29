import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {

    // Dos atributos usando Collection Framework
    private ArrayList<Card> deck;
    private LinkedList<Card> discarded;

    public Deck() {

        deck = new ArrayList<>();
        discarded = new LinkedList<>();

        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K", "A"
        };

        for (String palo : palos) {

            String color;

            if (palo.equals("Corazones") || palo.equals("Diamantes")) {
                color = "Rojo";
            } else {
                color = "Negro";
            }

            for (String valor : valores) {
                deck.add(new Card(palo, color, valor));
            }
        }
    }

    // Mezclar deck
    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
    }

    // Mostrar primera carta
    public void head() {

        if (deck.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
            return;
        }

        Card card = deck.remove(0);
        discarded.add(card);

        System.out.println(card);
        System.out.println("Quedan " + deck.size() + " cartas en el deck");
    }

    // Carta aleatoria
    public void pick() {

        if (deck.isEmpty()) {
            System.out.println("No hay cartas disponibles.");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(deck.size());

        Card card = deck.remove(index);
        discarded.add(card);

        System.out.println(card);
        System.out.println("Quedan " + deck.size() + " cartas en el deck");
    }

    // Mano de 5 cartas
    public Card[] hand() {

        if (deck.size() < 5) {
            System.out.println("No hay suficientes cartas.");
            return null;
        }

        Card[] handCards = new Card[5];

        for (int i = 0; i < 5; i++) {

            Card card = deck.remove(0);
            discarded.add(card);

            handCards[i] = card;

            System.out.println(card);
        }

        System.out.println("Quedan " + deck.size() + " cartas en el deck");

        return handCards;
    }
}
