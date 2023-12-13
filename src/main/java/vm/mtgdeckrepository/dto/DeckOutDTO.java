package vm.mtgdeckrepository.dto;

import java.util.List;

public class DeckOutDTO {
    private long deck_id;
    private PlayerOutDTO creator;
    private String deck_name;
    private String format;
    private List<CardInDeckDTO> main_deck;
    private List<CardInDeckDTO> sideboard;

    public DeckOutDTO() {}

    public DeckOutDTO(long deck_id, PlayerOutDTO creator, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        this.deck_id = deck_id;
        this.creator = creator;
        this.deck_name = deck_name;
        this.format = format;
        this.main_deck = main_deck;
        this.sideboard = sideboard;
    }

    public long getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(long deck_id) {
        this.deck_id = deck_id;
    }

    public PlayerOutDTO getCreator() {
        return creator;
    }

    public void setCreator(PlayerOutDTO creator) {
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
