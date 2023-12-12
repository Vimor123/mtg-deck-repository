package vm.mtgdeckrepository.dto;

import java.util.List;

public class DeckInDTO {
    private String deck_name;
    private String format;
    private List<CardInDeckDTO> main_deck;
    private List<CardInDeckDTO> sideboard;

    public DeckInDTO() {}

    public DeckInDTO(String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        this.deck_name = deck_name;
        this.format = format;
        this.main_deck = main_deck;
        this.sideboard = sideboard;
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

    public List<CardInDeckDTO> getMain_deck() {
        return main_deck;
    }

    public void setMain_deck(List<CardInDeckDTO> main_deck) {
        this.main_deck = main_deck;
    }

    public List<CardInDeckDTO> getSideboard() {
        return sideboard;
    }

    public void setSideboard(List<CardInDeckDTO> sideboard) {
        this.sideboard = sideboard;
    }
}
