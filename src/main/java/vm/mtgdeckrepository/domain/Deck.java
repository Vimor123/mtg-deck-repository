package vm.mtgdeckrepository.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Deck {
    @Id
    @GeneratedValue
    private Long deck_id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player creator;

    private String deck_name;

    private String format;

    @OneToMany(mappedBy = "deck")
    private Set<CardInDeck> cards;

    public Deck() {}

    public Deck(Player creator, String deck_name, String format) {
        this.creator = creator;
        this.deck_name = deck_name;
        this.format = format;
        this.cards = new HashSet<>();
    }

    public Long getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(Long deck_id) {
        this.deck_id = deck_id;
    }

    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    public String getDeck_name() {
        return deck_name;
    }

    public void setDeck_name(String deck_name) {
        this.deck_name = deck_name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Set<CardInDeck> getCards() {
        return cards;
    }

    public void setCards(Set<CardInDeck> cards) {
        this.cards = cards;
    }
}
