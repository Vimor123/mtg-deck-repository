package vm.mtgdeckrepository.service.impl;

import org.springframework.stereotype.Service;
import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.dto.CardInDeckDTO;
import vm.mtgdeckrepository.service.DeckService;

import java.util.List;

@Service
public class DeckServiceJpa implements DeckService {
    @Override
    public Deck createDeck(String creator, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        return null;
    }

    @Override
    public List<Deck> getAll() {
        return null;
    }

    @Override
    public Deck getById(long id) {
        return null;
    }

    @Override
    public Deck updateDeck(long id, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        return null;
    }

    @Override
    public void deleteDeck(long id) {

    }
}
