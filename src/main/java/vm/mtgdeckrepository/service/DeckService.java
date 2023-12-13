package vm.mtgdeckrepository.service;

import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.dto.CardInDeckDTO;

import java.util.List;

public interface DeckService {
    Deck createDeck(Player creator, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard);
    List<Deck> getAll();
    Deck getById(long id);
    Deck updateDeck(long id, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard);
    void deleteDeck(long id, String username);
}
