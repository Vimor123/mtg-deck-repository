package vm.mtgdeckrepository.domain;

import jakarta.persistence.*;

@Entity
public class CardInDeck {
    @Id
    @GeneratedValue
    private long card_in_deck_id;

    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    private String card_name;

    private int quantity;

    private boolean in_main_deck;

    public CardInDeck() {}

    public CardInDeck(Deck deck, String card_name, int quantity, boolean in_main_deck) {
        this.deck = deck;
        this.card_name = card_name;
        this.quantity = quantity;
        this.in_main_deck = in_main_deck;
    }

    public long getCard_in_deck_id() {
        return card_in_deck_id;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIn_main_deck() {
        return in_main_deck;
    }

    public void setIn_main_deck(boolean in_main_deck) {
        this.in_main_deck = in_main_deck;
    }
}
